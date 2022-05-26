import React, {useState, useEffect} from 'react';

import "./ConversationList.css"
import axios from "axios";
import ConversationListItem from "./ConversationListItem";

export default function ConversationList(props) {
    const [conversations, setConversations] = useState([]);
    useEffect(() => {
        getConversations()
    }, [])

    const getConversations = () => {
        axios.get('https://randomuser.me/api/?results=20').then(response => {
            let newConversations = response.data.results.map(result => {
                return {
                    photo: result.picture.large,
                    name: `${result.name.first} ${result.name.last}`,
                    mes_text: `${result.gender}`,
                    unread: `${Math.floor(Math.random() * 8)}`
                };
            });
            setConversations([...conversations, ...newConversations])
        });
    }
    return (

        <div className="container">
                <div className="conversation-list-card">
                    <div id="plist" className="people-list">
                        <div className="input-group">
                            <div className="input-group-prepend">
                                <span className="input-group-text"><i className="fa fa-search"></i></span>
                            </div>
                            <input type="text" className="form-control" placeholder="Search..."/>
                        </div>

                        {
                            conversations.map(conversation =>

                                <ConversationListItem
                                    key={conversation.name}
                                    data={conversation}
                                />
                            )
                        }

                    </div>
                </div>

        </div>
    );
}