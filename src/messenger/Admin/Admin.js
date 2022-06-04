import {NavBar} from "../Navigation/NavBar";
import * as React from 'react';
import "./Admin.css"
import "../../index.css"
import UserList from "./userList/userList";
import ReportList from "./reportList/reportList";
import {useState} from "react";


export default function Admin() {
    const [showUser, setShowUser] = useState(false)
    const [showReport, setShowReport] = useState(false)
    return (
        <div className="messenger">
            <NavBar/>
            <div className="app1">
                <div className="container">
                    <div className="admin-box">
                        <span className="textA">admin page</span>
                        <div className="search-box">
                            {/*<ConversationSearch/>*/}
                        </div>
                        <div className="admin-page-element">
                            <button type="button" className="btn-userList" onClick={() => setShowUser(true) }>
                                users list
                            </button>
                        </div>
                        <UserList onClose={() =>setShowUser(false)} show={showUser}/>

                        <div className="admin-page-element">
                            <button type="button" className="btn-reportList" onClick={() => setShowReport(true)}>
                                reports list
                            </button>
                        </div>
                        <ReportList onClose={() =>setShowReport(false)} show={showReport}/>

                    </div>
                </div>
            </div>
        </div>
);
}