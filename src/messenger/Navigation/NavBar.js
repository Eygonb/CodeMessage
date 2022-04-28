import * as React from 'react';

import homeIMG from '../assets/home.png';
import profileIMG from '../assets/profile.png';
import addIMG from '../assets/add.png';
import settingsIMG from '../assets/settings.png';

import {Link} from "react-router-dom";

import './Nav-styles.css';

export const NavBar = () => {
    return (<div className="navbar-cm">

            <div className="nav_element">
                <Link to="/">
                    <img src={homeIMG} className="nav_element"/>
                </Link>
            </div>

            <div className="nav_element">
                <Link to="/profile">
                <img src={profileIMG} className="nav_element"/>
            </Link>
            </div>

            <div className="nav_element">
                <img src={addIMG} className="nav_element"/>
            </div>

            <div className="nav_element">
                <Link to="/settings">
                    <img src={settingsIMG} className="nav_element"/>
                </Link>
            </div>

            <div className="nav_element">
                <Link to="/login">
                    <img src={settingsIMG} className="nav_element"/>
                </Link>
            </div>

        </div>);
};