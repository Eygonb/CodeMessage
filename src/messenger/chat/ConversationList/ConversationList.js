import React, {useState, useEffect} from 'react';

import "./ConversationList.css"
import axios from "axios";
import ConversationListItem from "./ConversationListItem";
import AddChat from "../AddChat";
import JsonData from "../../../testdata/ConversList.json"
import api from "../../Login/services";
import Cookies from "js-cookie";


export default function ConversationList(props) {
    const [token, setTokenData] = useState(null);
    const [conversations, setConversations] = useState([]);
    const [isOpen, setIsOpen] = useState(false);


    useEffect(() => {
        getConversations()
    }, [])

    const getConversations = (page, size) => {
        const tokenData = Cookies.get("auth-token");

        setTokenData(tokenData);
        // console.log(token)
        const requestOptions = {
            headers: {
                'Content-Type': 'application/json'
            }
        };
        api.auth.getChatsList(requestOptions, 0, 20)
            .then(function (response) {
                // console.log(response.data);
                setConversations([...conversations, ...response.data])
            });
    }

    const togglePopup = () => {
        setIsOpen(!isOpen);
    }

    const setStorage = (data) =>{
        localStorage.setItem('selectedChat',data);
        // Cookies.remove('selectedChat')
        // Cookies.set("selectedChat", chat.id)
        // console.log(localStorage.getItem("selectedChat"))
    }

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
                    <div>
                        {conversations.map((conversation) => {
                                return (
                                    <ConversationListItem
                                        onClick={setStorage(conversation.id)}
                                        chat={conversation}
                                        key={conversation.id}
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