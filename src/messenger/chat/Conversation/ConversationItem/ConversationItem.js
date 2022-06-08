import React from 'react';
import Cookies from "js-cookie";

const ConversationItem = ({messages, imgId, myID}) => {
    console.log(myID)
    return (
        <div>
            {messages.user_id === myID ?
                <div className="d-flex justify-content-start mb-4">
                    <div className="img_cont_msg">
                        <img src={imgId} className="rounded-circle user_img_msg" alt ='userLogo'/>
                    </div>
                    <div className="msg_container">
                        <div>
                            {messages.textMsg}</div>
                        {messages.wasChanged === "false" ?
                            <span className="msg_time">{messages.timeMsg}</span>
                            : <span className="msg_time">{messages.timeMsg}
                                <span className="msg_was_changed"> изменено
                                                </span>
                                            </span>
                        }
                    </div>
                </div>
                :
                <div className="d-flex justify-content-end mb-4">
                    <div className="msg_container_send">
                        <div>
                            {messages.textMsg}</div>
                        {messages.wasChanged === "false" ?
                            <span className="msg_time_send">{messages.timeMsg}</span>
                            : <span className="msg_time_send">{messages.timeMsg}
                                <span className="msg_was_changed_send"> изменено
                                                </span>
                                            </span>
                        }
                    </div>
                    <div className="img_cont_msg">
                        <img src="https://randomuser.me/api/portraits/men/33.jpg"
                             className="rounded-circle user_img_msg" alt ='/userlogo'/>
                    </div>
                </div>
            }
        </div>
    );
};

export default ConversationItem;