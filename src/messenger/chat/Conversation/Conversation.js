import React, {useState, useEffect} from 'react';
import './chat.css'
import PopupConv from "./PopupConv";
import JsonData from "../../../testdata/testChat.json"

export default function Conversation(props) {
    const [isOpen, setIsOpen] = useState(false);

    const togglePopup = () => {
        setIsOpen(!isOpen);
    }
    const {id, imgId, chatName, mes_text, unread} = props.data;
    //todo добавить unread в пропсдату
    const {mes_id, text_msg, chat_id, user_id, time_msg, was_changed} = props.data;


    return (
        <div className="container">
            <div className="col-md-8 col-xl-6">
                <div className="card-box">
                    <div className="card chat">
                        <div className="card-header msg_head">
                            <div className="d-flex bd-highlight">
                                <div className="img_cont">
                                    <img src={imgId} className="rounded-circle user_img"/>
                                    <span className="online_icon"></span>
                                </div>
                                <div className="user_info">
                                    <h6 className="m-b-0">{chatName}</h6>
                                    <div className='conv-status'>Online</div>
                                </div>
                            </div>
                            <span id="action_menu_btn" onClick={togglePopup}>
                            <i className="fa fa-ellipsis-v"></i>
                        </span>

                        </div>
                        {isOpen && <PopupConv data={props.data} handleClose={togglePopup}/>}

                        <div className="card-body msg_card_body">
                            {JsonData.map((message) => {
                                    return (
                                        <div>
                                            {message.user_id == 1 ?
                                                <div className="d-flex justify-content-start mb-4">
                                                    <div className="img_cont_msg">
                                                        <img src={imgId} className="rounded-circle user_img_msg"/>
                                                    </div>
                                                    <div className="msg_cotainer">
                                                        <div>
                                                            {message.text_msg}</div>
                                                        {message.was_changed == "false" ?
                                                            <span className="msg_time">{message.time_msg}</span>
                                                            : <span className="msg_time">{message.time_msg}
                                                                <span className="msg_was_changed"> изменено
                                                            </span>
                                                    </span>
                                                        }

                                                    </div>
                                                </div>
                                                :
                                                <div className="d-flex justify-content-end mb-4">
                                                    <div className="msg_cotainer_send">
                                                        <div>
                                                            {message.text_msg}</div>
                                                        {message.was_changed == "false" ?
                                                            <span className="msg_time_send">{message.time_msg}</span>
                                                            : <span className="msg_time_send">{message.time_msg}
                                                                <span className="msg_was_changed_send"> изменено
                                                            </span>
                                                        </span>}
                                                    </div>
                                                    <div className="img_cont_msg">
                                                        <img src="https://randomuser.me/api/portraits/men/33.jpg"
                                                             className="rounded-circle user_img_msg"/>
                                                    </div>
                                                </div>
                                            }
                                        </div>
                                    )
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