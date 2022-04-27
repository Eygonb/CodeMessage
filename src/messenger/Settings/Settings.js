import * as React from 'react';
import {Component} from "react";

import './Settings.css';
import {NavBar} from "../Navigation/NavBar";

export default class Settings extends Component {
    render() {
        return (
            <div>
                <NavBar/>

                <div className="settings-box">
                    <span className="text-center1">Settings</span>
                    <div className="settings-item">
                        <p className="text-center1">1</p>
                    </div>
                    <div className="settings-item">
                        <p className="text-center1">2</p>
                    </div>
                    <div className="settings-item">
                        <p className="text-center1">3</p>
                    </div>
                    <div className="settings-item">
                        <p className="text-center1">4</p>
                    </div>
                </div>

            </div>
        );
    }
}