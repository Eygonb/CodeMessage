import {useState, useEffect} from 'react';
import React, {Component} from "react";
import './Login.css';
import {Link} from "react-router-dom";

function Register (props){
    const [email, setEmail] = useState('')
    const [username, setUsername] = useState('')
    const [password, setPassword] = useState('')
    const [message, setMessage] = useState('')
    const [error, setError] = useState('')

    const handleChange = (event) =>{
        this.setState({
            [event.target.name]: event.target.value
        });
    }

    const handleRegisterClick = (event) => {
        console.log('Try to register', this.state.email, this.state.password);
        const body = {
            email,
            password
        };
        fetch('localhost:8080/accounts/register ', {
            method: 'POST',
            body: JSON.stringify(body),
            headers: {
                'Content-Type': 'application/json'
            }
        //    todo - ошибка 400
        }).then(response => response.json()
        ).then(json => this.setState({
            message: json.message
        }));
        event.preventDefault();
    }

    // blurHandler = (e) => {
    //     switch (e.target.name) {
    //         case "email":
    //             this.state.emailDirty(true)
    //             break
    //         case "password":
    //             this.state.passwordDirty(true)
    //             break
    //     }
    // }
    // passwordHandler = (e) => {
    //     this.state.password(e.target.value)
    //
    //     if (e.target.value.length < 3) {
    //         this.state.passwordError("Password должен быть длиннее 3 символов!")
    //         if (!e.target.value) {
    //             this.state.passwordError("Password не может быть пустым!")
    //         }
    //     } else {
    //         this.state.passwordError('')
    //     }
    // }
    // emailHandler = (e) => {
    //     this.state.emailError(e.target.value)
    //     const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
    //     if (!re.test(String(e.target.value).toLowerCase())) {
    //         this.state.emailError("email некоректный!")
    //     } else {
    //         this.state.emailError('')
    //     }
    // }

        return (
            <div className="messenger">
                <form>
                    <div className="login-box">
                        <span className="text-center">Registration</span>
                        <div className="input-container">

                            <div className="error-text">
                                {message ? message : ''}
                            </div>

                        </div>

                        <div className="input-container">
                            <input onChange={handleChange}
                                   type="text"
                                   name="username"
                                   id="username"
                                   className="validate"
                                   required="required"/>
                            <label>Username</label>
                        </div>

                        <div className="input-container">
                            <input

                                value={email}
                                name="email"
                                id="email"
                                className="validate"
                                required="required"/>
                            <label>Email</label>
                        </div>

                        <div className="input-container">
                            <input
                                onChange={handleChange}
                                type="password"
                                name="password"
                                id="password"
                                className="validate"
                                required="required"/>
                            <label>Password</label>
                        </div>

                        <button className="btn1"
                                variant="primary"
                                type="submit"
                                onClick={handleRegisterClick}>submit</button>

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
export  default Register;