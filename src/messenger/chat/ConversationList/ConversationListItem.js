import React, {useEffect} from 'react';
import "./ConversationList.css"
import shave from 'shave';

export default function ConversationListItem(props) {
    useEffect(() => {
        shave('.conversation-snippet', 20);
    })

    const {id, imgId, chatName, mes_text, unread} = props.data;
    //todo добавить unread в пропсдату

    return (

        <div className="conversation-list-item">
            <ul className="list-unstyled chat-list mt-2 mb-0">
                <li className="clearfix">
                    <img src={imgId} alt="avatar"/>
                    <div className="about">
                        <h6>{chatName}</h6>
                        <div className="last-mes">
                            <div className="last-mes-text">{mes_text}</div>
                            {(unread != 0) &&
                                <div className="unread">
                                    {unread}
                                </div>
                            }
                        </div>

                        <div className="status"><i className="fa fa-circle offline"></i> left 7 mins ago
                        </div>
                    </div>
                </li>
            </ul>

        </div>
    );
}