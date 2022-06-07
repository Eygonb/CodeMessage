import React, {useState, useEffect} from 'react';
import './chat.css'
import PopupConv from "./PopupConv";
// import JsonData from "../../../testdata/chat/1.json"

import JsonData from "../../../testdata/chat/2.json"
import ConversationItem from "./ConversationItem/ConversationItem";

export default function Conversation(props) {
    const [isOpen, setIsOpen] = useState(false);

    const togglePopup = () => {
        setIsOpen(!isOpen);
    }
    const {imgId, chatName} = props.data;
    const messagesList = JsonData;
    return (
        <div className="container">
            <div className="col-md-8 col-xl-6">
                <div className="card-box">
                    <div className="card chat">
                        <div className="card-header msg_head">
                            <div className="d-flex bd-highlight">
                                <div className="img_cont">
                                    <img src={imgId} className="rounded-circle user_img" alt ='userLogo'/>
                                    <span className="online_icon"></span>
                                </div>
                                <div className="user_info">
                                    <h6>{chatName}</h6>
                                    <div className='conv-status'>Online</div>
                                </div>
                            </div>
                            <span id="action_menu_btn" onClick={togglePopup}>
                            <i className="fa fa-ellipsis-v"></i>
                        </span>
                        </div>
                        {isOpen && <PopupConv data={props.data} handleClose={togglePopup}/>}
                        <div className="card-body msg_card_body">
                            {messagesList.map((message) => {

                                    return (
                                        <ConversationItem messages={message} imgId={imgId} key={message.mes_id}/>)
                                }
                            )}
                        </div>

                        <div className="card-footer">
                            <div className="input-group">
                                <div className="input-group-append">
                                <span className="input-group-text attach_btn"><i
                                    className="fa fa-paperclip"></i></span>
                                </div>
                                <textarea name="" className="form-control type_msg"
                                          placeholder="Type your message..."></textarea>
                                <div className="input-group-append">
                                <span className="input-group-text send_btn"><i
                                    className="fa fa-location-arrow"></i></span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    );
}