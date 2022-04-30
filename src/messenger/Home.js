import React, {useState, useEffect, Component} from 'react';
import {NavBar} from "./Navigation/NavBar";
import ChatMenu from "./ChatMenu";

export default class Home extends Component {
    render() {
        return (
            <div className="messenger">
                <NavBar/>
                <ChatMenu/>
            </div>
        );
    }
}