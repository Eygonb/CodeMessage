import React, {useEffect} from 'react';
import "./ConversationList.css"
import shave from 'shave';
import JsonData from "../../../testdata/ConversList.json"

function ConversationListItem({chat, change}) {
    useEffect(() => {
        shave('.conversation-snippet', 20);
    })

    return (
        <div  onClick={() => change(chat.id)}>
            <div className="conversation-list-item"
                 >
                <ul className="list-unstyled chat-list mt-2 mb-0">
                    <li className="clearfix">
                        <img src={chat.imgId} alt="avatar"/>
                        <div className="about">
                            <h6>{chat.chatName}</h6>
                            <div className="last-mes">
                                <div className="last-mes-text">{chat.mes_text}</div>
                                {chat.unread !== 0 &&
                                    <div className="unread">
                                        {chat.unread}
                                    </div>
                                }
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>

    );
}
export default ConversationListItem;