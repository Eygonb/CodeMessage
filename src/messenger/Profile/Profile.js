import {NavBar} from "../Navigation/NavBar";
import * as React from 'react';
import "./Profile.css"
import "../../index.css"

import profileIMG from '../assets/profile.png';

export default function UserProfile() {

    return (
        <div className="messenger" >
            <NavBar/>
            <div className="profile-box">
                {/*<span className="text-center">Profile</span>*/}

                <div className="profile-header">
                    <div className="profile-header-item">

                        <img src={profileIMG} className="profile-header-item"/>
                        <span className="profile-header-item text-center1">NAme</span>
                    </div>
                </div>

                <div className="profile-element">
                    <span className="profile-header-item text1">Some User Description</span>
                    <p className="text-description">
                        About User
                    </p>
                    <span className="profile-header-item text1">@username</span>
                    <p className="text-description">
                        username
                    </p>
                </div>

                <div className="profile-element profile-header-item">
                    <button type="button" className="btn-send">
                        <span className="text1">Send Message</span>
                    </button>
                </div>

                <div className="profile-element profile-header-item">
                    <button type="button"  className="btn-send" style={{backgroundColor: "#00793CFF"}} >
                        <span className="text1">Edit Profile</span>
                    </button>
                </div>


            </div>
        </div>
    );
}