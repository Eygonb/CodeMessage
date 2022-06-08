import * as React from 'react';
import {Link} from "react-router-dom";

import './Nav-styles.css';
import Cookies from "js-cookie";
const tokenData = Cookies.get("auth-token");
export const NavBar = () => {
    return (

        <div className="navbar-cm">
            <div className="nav_element-box">
                <div className="nav_element">
                    <Link to="/">
                        <i className="nav_element fa fa-home  fa-fw"></i>
                    </Link>
                </div>
            </div>
            <div className="nav_element-box">
                <div className="nav_element">
                    <Link to="/profile">
                        <i className="nav_element fa fa-user  fa-fw"></i>
                        {/*<img src={profileIMG} className="nav_element"/>*/}
                    </Link>
                </div>
            </div>
            <div className="nav_element-box">
                <div className="nav_element">
                    <Link to="/settings">
                        <i className="nav_element fa fa-cog  fa-fw"></i>
                    </Link>
                </div>
            </div>

            <div className="nav_element-box">
                <div className="nav_element">

                    <Link to="/login">
                        <i className="nav_element fa fa-id-badge  fa-fw"></i>
                        {/*<img src={loginIMG} className="nav_element"/>*/}
                    </Link>
                </div>
            </div>
            <div className="nav_element-box">
                <div className="nav_element">
                    <Link to="/admin">
                        <i className="nav_element fa fa-eye  fa-fw"></i>
                    </Link>
                </div>
            </div>

        </div>
    );
};