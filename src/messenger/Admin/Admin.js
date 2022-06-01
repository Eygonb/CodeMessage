import {NavBar} from "../Navigation/NavBar";
import * as React from 'react';
import "./Admin.css"
import "../../index.css"


export default function Admin() {

    return (
        <div className="bx">
                <NavBar/>

                <div className="admin-box">
                    <span className="textA">admin page</span>
                    <div className="search-box">
                        {/*<ConversationSearch/>*/}
                    </div>
                    <div className="admin-page-element">
                        <button type="button" className="btn-admin">
                            users list
                        </button>
                    </div>
                    <div className="admin-page-element" >
                        <button type="button" className="btn-admin" style={{backgroundColor: "#006DC0FF"}}>
                            reports list
                        </button>
                    </div>
                </div>

        </div>
    );
}