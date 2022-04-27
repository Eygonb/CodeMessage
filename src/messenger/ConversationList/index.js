import React, {useState, useEffect} from 'react';
import ConversationSearch from '../ConversationSearch';
import ConversationListItem from '../ConversationListItem';
import axios from 'axios';

import './ConversationList.css';


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
        <div className="conversation-list">
            <ConversationSearch/>
            {
                conversations.map(conversation =>
                    <ConversationListItem
                        key={conversation.name}
                        data={conversation}
                    />
                )
            }
        </div>
    );
}