import {NavBar} from "../Navigation/NavBar";
import React, {useState} from 'react';
import "./Profile.css"
import "../../index.css"

import JsonData from "../../testdata/account.json"
import PopupReport from "./PopupReport";

export default function UserProfile() {
    const [showReport, setShowReport] = useState(false)
    return (
        <div className="messenger">
            <NavBar/>
            <div className="app1">
                {JsonData.map((user) => {
                    return (
                        <div className="container">
                            <div className="profile-box">
                                <div className="profile-header">
                                    <div className="d-flex bd-highlight">
                                        <div className="profile-header-item">
                                            <img src={user.img_id} className="rounded-circle profile-image"/>
                                            <div className="profile-info">
                                                <h2>{user.username}</h2>
                                                <p>{user.email}</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div className="profile-element">
                                    <h3>{user.title}</h3>
                                    <p className="text-description">
                                        About User
                                    </p>
                                    <div className="delimiting"></div>
                                    <h3> @{user.username}</h3>
                                    <p className="text-description">
                                        username
                                    </p>
                                </div>

                                <div className="profile-element profile-header-item profile-button">
                                    {user.id !== 1 &&
                                        <button type="button" className="btn-send">
                                            <span className="text1">Send Message</span>
                                        </button>
                                    }
                                    {
                                        user.id == 1 ?
                                            <button type="button" className="btn-edit">
                                                <span className="text1">Edit Profile</span>
                                            </button>
                                            :
                                            <div>
                                                <button type="button" className="btn-edit">
                                                   Block
                                                </button>
                                                <button type="button" className="btn-edit" onClick={() => setShowReport(true)}>
                                                    Report
                                                </button>
                                            </div>
                                    }
                                </div>
                                <PopupReport onClose={() =>setShowReport(false)} show={showReport}/>
                            </div>
                        </div>
                    )
                })}
            </div>
        </div>
    );
}