import React, {useState, useEffect} from 'react';

import "./ConversationList.css"
import axios from "axios";
import ConversationListItem from "./ConversationListItem";
import AddChat from "../AddChat";
import JsonData from "../../../testdata/ConversList.json"


export default function ConversationList(props, changeChatID) {
    const [conversations, setConversations] = useState([]);
    useEffect(() => {
        getConversations()
    }, [])

    const [isOpen, setIsOpen] = useState(false);
    const ConversationList = JsonData;
    const togglePopup = () => {
        setIsOpen(!isOpen);
    }

    const getConversations = () => {
        axios.get('https://randomuser.me/api/?results=20').then(response => {
            let newConversations = response.data.results.map(result => {
                return {
                    id: result.login.uuid,
                    imgId: result.picture.large,
                    chatName: `${result.name.first} ${result.name.last}`,
                    mes_text: `${result.gender}`,
                    unread: `${Math.floor(Math.random() * 8)}`
                };
            });
            setConversations([...conversations, ...newConversations])
        });
    }

    const [selectChatid, setSelectChatid] = useState(0)

    return (
        <div className="container" >
            <div className="conversation-list-card">
                <div id="plist" className="people-list">
                    <div className="input-group">
                        <input type="text" className="form-control search" placeholder="Search..."/>
                        <div className="input-group-prepend input-button">
                            <span className="input-group-text"><i className="fa fa-search"></i></span>
                        </div>
                        <div className="input-group-prepend input-button">
                            <span className="input-group-text action_menu_btn" onClick={togglePopup}><i
                                className="fa fa-plus"></i></span>
                        </div>
                    </div>
                    {/*{console.log(selectChatid)}*/}
                    <div onChange={() => changeChatID(selectChatid) }>
                    {ConversationList.map((conversation) => {
                        return(

                                <ConversationListItem
                                    chat = {conversation}
                                    key ={conversation.id}
                                    change={selectChatid =>setSelectChatid(selectChatid)}
                                />


                        )
                        }
                    )}</div>
                </div>
            </div>

            {isOpen && <AddChat data={props.data} handleClose={togglePopup}/>}
        </div>
    );
}