import React, {useState, useEffect} from 'react';
import axios from "axios";
import ConversationList from "./ConversationList/ConversationList";
import Conversation from "./Conversation/Conversation";

import JsonData from "../../testdata/chat/1.json"
import JsonData2 from "../../testdata/chat/2.json"

export default function ChatMenu() {

    const [user, setConversations] = useState([]);

    useEffect(() => {
        getConversations()
    }, [])
    //todo изменить при рендере выбранных чатов дефолт значение на ноль
    const [selectChatid, setSelectChatid] = useState(1)

    const handlChangeID= (usID) =>{
        setSelectChatid(usID)
    }

    // const getConversations = () => {
    //     let userID = selectChatid
    //     let selectUser = ''
    //     if (userID === 1) {
    //         selectUser = JsonData
    //     }
    //     if (userID === 2) {
    //         selectUser = JsonData2
    //     }
    //     setConversations(selectUser)
    //     console.log(selectUser)
    // }

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
            <ConversationList
                changeChatID ={selectChatid =>setSelectChatid(selectChatid)}
            />
            {user === 0 ?
                <div/>
                :
                user.map(conversation =>
                    <Conversation
                        key={conversation.id}
                        data={conversation}
                    />
                )
            }

        </div>
    );
}