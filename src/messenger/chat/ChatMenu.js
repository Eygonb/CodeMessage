import React, {useState, useEffect} from 'react';
import axios from "axios";
import ConversationList from "./ConversationList/ConversationList";
import Conversation from "./Conversation/Conversation";
import Cookies from 'js-cookie'
import api from "../Login/services";


export default function ChatMenu() {

    const [token, setTokenData] = useState(null);
    const [conversations, setConversations] = useState([]);
    let selectedChat =Cookies.get("selectedChat")

    useEffect(() => {
        getConversations()
    }, [])


    const getConversations = (page, size) => {
        const tokenData = Cookies.get("auth-token");

        setTokenData(tokenData);
        console.log(Cookies.get("auth-token"))
        const requestOptions = {
            headers: {
                'Content-Type': 'application/json'
            }
        };
        api.auth.getChatByID(requestOptions, selectedChat)
            .then(function (response) {
                // console.log(response.data);
                setConversations([...conversations, ...response.data])
            });
    }


    return (
        <div className='app1'>

            <ConversationList/>
            {selectedChat === 0 ?
                <div/>
                :
                conversations.map(conversation =>
                    <Conversation
                        key={conversation.selectedChat}
                        data={conversation}
                    />
                )
            }

        </div>
    );
}