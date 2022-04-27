import React, {useEffect} from 'react';
import './ConversationListItem.css';
import profileIMG from "../assets/profile.png";
import shave from 'shave';

export default function ConversationListItem(props) {
    useEffect(() => {
        shave('.conversation-snippet', 20);
    })

    const { photo, name, mes_text, unread} = props.data;
    //todo добавить unread в пропсдату

    return (

        <div className="conversation-list-item">
            <img className="conversation-photo" src={photo} alt="conversation"/>
            <div className="conversation-info">

                <h1 className="conversation-title">{ name }</h1>
                <p className="conversation-text">{mes_text}</p>
                { (unread !=0)&&
                <div className="unread1">
                    <p className="unread">{unread}</p>
                </div>
                }
            </div>

        </div>
    );
}