import React, {useState, useEffect} from 'react';
import './Conversation/chat.css'

export default function AddChat() {
    return (
        <div className="action_menu">

            <ul>
                <li><h4>Создание беседы</h4></li>
                <li><textarea name="" className="form-control type_msg"
                              placeholder="Введите название беседы"></textarea></li>
                <li><i className="fa fa-user-circle"></i> View profile</li>
                <li><textarea name="" className="form-control type_msg"
                              placeholder="Введите username или @tag"></textarea></li>
                <li><i className="fa fa-user-circle"></i> View profile</li>
                <li><i className="fa fa-users"></i> username</li>
                <li><i className="fa fa-users"></i> username</li>
                <li><i className="fa fa-users"></i> username</li>
            </ul>
        </div>
    );
}