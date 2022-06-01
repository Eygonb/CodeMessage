import React, {useState, useEffect, Component} from 'react';
import './Login.css';
import {Link} from "react-router-dom";

const Register = () => {

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [emailDirty, setEmailDirtty] = useState(false);
    const [passwordDirty, setPasswordDirty] = useState(false);
    const [emailError, setEmailError] = useState('Email не может быть пустым');
    const [passwordError, setPasswordError] = useState('Password не может быть пустым');



    const emailHandler = (e) =>{
        setEmail(e.target.value)
        const re =  /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
        if (!re.test(String(e.target.value).toLowerCase())){
            setEmailError("email некоректный!")
        }else{
            setEmailError('')
        }
    }

    const passwordHandler = (e) =>{
        setPassword(e.target.value)

        if (e.target.value.length<3){
            setPasswordError("Password должен быть длиннее 3 символов!")
            if(!e.target.value){
                setPasswordError("Password не может быть пустым!")
            }
        }else{
            setPasswordError('')
        }
    }

    const blurHandler = (e) => {
        switch (e.target.name) {
            case "email":
                setEmailDirtty(true)
                break
            case "password":
                setPasswordDirty(true)
                break
        }
    }

    return (
        <div className="messenger">
            <form>
                <div className="login-box">

                    <span className="text-center">Registration</span>
                    <div className="input-container">
                        {(emailDirty && emailError) && <div className="error-text"> {emailError}</div>}
                        {(passwordDirty && passwordError) && <div className="error-text"> {passwordError}</div>}

                    </div>

                    <div className="input-container">
                        <input name="username" id="username" className="validate" required="required"/>
                        <label>Username</label>
                    </div>

                    <div className="input-container">
                        <input onBlur={e => blurHandler(e)} onChange={e => emailHandler(e)}
                               value={email} name="email" id="email" className="validate" required="required"/>
                        <label>Email</label>
                    </div>

                    <div className="input-container">
                        <input onBlur={e => blurHandler(e)} onChange={e => passwordHandler(e)}
                               value={password} name="password" id="password" type="password" className="validate"
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
export default Register;