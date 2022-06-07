import React from 'react';

const ConversationItem = ({messages, imgId}) => {
    return (
        <div>
            {messages.user_id === 1 ?
                <div className="d-flex justify-content-start mb-4">
                    <div className="img_cont_msg">
                        <img src={imgId} className="rounded-circle user_img_msg" alt ='userLogo'/>
                    </div>
                    <div className="msg_container">
                        <div>
                            {messages.text_msg}</div>
                        {messages.was_changed === "false" ?
                            <span className="msg_time">{messages.time_msg}</span>
                            : <span className="msg_time">{messages.time_msg}
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
                            {messages.text_msg}</div>
                        {messages.was_changed === "false" ?
                            <span className="msg_time_send">{messages.time_msg}</span>
                            : <span className="msg_time_send">{messages.time_msg}
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