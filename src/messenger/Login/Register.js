import * as React from 'react';
import {Component} from "react";

import './Login.css';
import {Link} from "react-router-dom";

export default class Register extends Component {
    render() {
        return (
            <div className="messenger">
                <form>
                    <div className="login-box">

                        <span className="text-center">Registration</span>

                        <div className="input-container">
                            <input name="Username" id="Name" className="validate" required="required"/>
                            <label>Username</label>
                        </div>
                        <div className="input-container">
                            <input name="Email" id="Name" className="validate" required="required"/>
                            <label>Email</label>
                        </div>

                        <div className="input-container">
                            <input name="Password" id="Password" type="password" className="validate"
                                   required="required"/>
                            <label>Password</label>
                        </div>

                        <button type="button" className="btn1">submit</button>

                        <Link to="/login">
                            <button type="button" className="btn-register">
                                Login in
                            </button>
                        </Link>

                    </div>
                </form>
            </div>

        );
    }
}