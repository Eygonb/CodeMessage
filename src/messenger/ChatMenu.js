import React, {useState, useEffect} from 'react';
import ConversationList from "./ConversationList";
import MessageList from "./MessageList/MessageList";

export default function ChatMenu() {

    return (
        <div className="app1">

            <div className="sidebar">
                <ConversationList/>
            </div>
            <div className="content">
                <MessageList/>
            </div>
        </div>
    );
}