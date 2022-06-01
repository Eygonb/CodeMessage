import React, {useState, useEffect} from 'react';
import axios from "axios";
import ConversationList from "./ConversationList/ConversationList";
import Conversation from "./Conversation/Conversation";

export default function ChatMenu() {

    const [user, setConversations] = useState([]);
    useEffect(() => {
        getConversations()
    }, [])

    const getConversations = () => {
        axios.get('https://randomuser.me/api/?results=1').then(response => {
            let newConversations = response.data.results.map(result => {
                return {
                    id: result.login.uuid,
                    imgId: result.picture.large,
                    chatName: `${result.name.first} ${result.name.last}`,
                    mes_text: `${result.gender}`,
                    unread: `${Math.floor(Math.random() * 8)}`
                };
            });
            setConversations([...user, ...newConversations])
        });
    }

    return (
        <div className='app1'>
            <ConversationList/>
            {user.map(conversation =>

                    <Conversation
                        key={conversation.id}
                        data={conversation}
                    />
                )
            }

        </div>
    );
}