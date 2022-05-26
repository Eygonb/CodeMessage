import React, {useState, useEffect} from 'react';
import './chat.css'

export default function Conversation(props) {

    const {photo, name, mes_text, unread} = props.data;
    //todo добавить unread в пропсдату

    return (
        <div className="container">
            <div className="col-md-8 col-xl-6 chat">
                <div className="card">
                    <div className="card-header msg_head">
                        <div className="d-flex bd-highlight">
                            <div className="img_cont">
                                <img src={photo} className="rounded-circle user_img"/>
                                    <span className="online_icon"></span>
                            </div>
                            <div className="user_info">
                                <h6 className="m-b-0">{name}</h6>
                                <div className='conv-status'>Last seen: 2 hours ago</div>
                            </div>
                        </div>
                        <span id="action_menu_btn"><i className="fa fa-ellipsis-v"></i></span>
                        <div className="action_menu">
                            <ul>
                                <li><i className="fa fa-user-circle"></i> View profile</li>
                                <li><i className="fa fa-users"></i> Add to close friends</li>
                                <li><i className="fa fa-plus"></i> Add to group</li>
                                <li><i className="fa fa-ban"></i> Block</li>
                            </ul>
                        </div>
                    </div>
                    <div className="card-body msg_card_body">
                        <div className="d-flex justify-content-start mb-4">
                            <div className="img_cont_msg">
                                <img src={photo}
                                     className="rounded-circle user_img_msg"/>
                            </div>
                            <div className="msg_cotainer">
                                {mes_text}
                                <span className="msg_time">8:40 AM, Today</span>
                            </div>
                        </div>
                        <div className="d-flex justify-content-end mb-4">
                            <div className="msg_cotainer_send">
                                {mes_text}
                                <span className="msg_time_send">8:55 AM, Today</span>
                            </div>
                            <div className="img_cont_msg">
                                <img src="https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg"
                                    className="rounded-circle user_img_msg"/>
                            </div>
                        </div>
                        <div className="d-flex justify-content-start mb-4">
                            <div className="img_cont_msg">
                                <img src={photo}
                                     className="rounded-circle user_img_msg"/>
                            </div>
                            <div className="msg_cotainer">
                                {mes_text}
                                <span className="msg_time">9:00 AM, Today</span>
                            </div>
                        </div>
                        <div className="d-flex justify-content-end mb-4">
                            <div className="msg_cotainer_send">
                                {mes_text}
                                <span className="msg_time_send">9:05 AM, Today</span>
                            </div>
                            <div className="img_cont_msg">
                                <img src="https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg"
                                    className="rounded-circle user_img_msg"/>
                            </div>
                        </div>
                        <div className="d-flex justify-content-start mb-4">
                            <div className="img_cont_msg">
                                <img src={photo}
                                     className="rounded-circle user_img_msg"/>
                            </div>
                            <div className="msg_cotainer">
                                {mes_text}
                                <span className="msg_time">9:07 AM, Today</span>
                            </div>
                        </div>
                        <div className="d-flex justify-content-end mb-4">
                            <div className="msg_cotainer_send">
                                {mes_text}
                                <span className="msg_time_send">9:10 AM, Today</span>
                            </div>
                            <div className="img_cont_msg">
                                <img src="https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg"
                                    className="rounded-circle user_img_msg"/>
                            </div>
                        </div>
                        <div className="d-flex justify-content-start mb-4">
                            <div className="img_cont_msg">
                                <img src={photo}
                                     className="rounded-circle user_img_msg"/>
                            </div>
                            <div className="msg_cotainer">
                                {mes_text}
                                <span className="msg_time">9:12 AM, Today</span>
                            </div>
                        </div>
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
    );
}