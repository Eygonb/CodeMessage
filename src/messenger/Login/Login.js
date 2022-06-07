import React, {useState} from "react";

import './Login.css';
import '../../index.css';
import {Link} from "react-router-dom";

function Login (props, isLoggedIn) {
    const [username, setUsername] = useState('')
    const [password, setPassword]= useState('')
    const [message, setMessage]= useState('')
    const [authenticated, setAuthenticated] = useState(false)

    const [token, setToken]= useState('')

    const handleChangeUsername = (enterredUsername) =>{
       setUsername(enterredUsername)
    }

    const handleChangePassword =(enterredPassword) =>{
        setPassword(enterredPassword)
    }

    const handleLoginClick = (event) =>{
        console.log('Try to login ', username, password)
        const body = {
            username,
            password
        };
        fetch('http://localhost:8080/authenticate', {
            method: 'POST',
            body: JSON.stringify(body),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => {
            if (response.status === 200) {
                // setAuthenticated(true)
                console.log("LOGGED IN!")
                console.log(token)
                localStorage.setItem("isLoggedIn", true)
                localStorage.setItem("token", response.text())

            } else if (response.status === 401) {
                setMessage(response.text)
                console.log(response.text)
            } else {
                setMessage('Что-то пошло не так...')
            }
        });
        // event.preventDefault();
    }


    return (
        <div className="messenger" >
            <form>
                {console.log(localStorage.getItem("token"))}
                <div className="login-box">
                    <span className="text-center">login</span>
                    <span> {message} </span>
                    <div className="input-container">
                        <input className="validate" onChange={handleChangeUsername}
                               type="text"
                               name="username"
                               required="required"/>
                        <label>Username</label>
                    </div>

                    <div className="input-container">
                        <input onChange={handleChangePassword}
                               name="password"
                               id="password"
                               type="password"
                               className="validate"
                               required="required"/>
                        <label>Password</label>
                    </div>
                    <button className="btn1"
                            type="submit"
                            onClick={handleLoginClick}
                    >
                        submit
                    </button>

                    <Link to="/register">
                        <button type="button" className="btn-register">
                            register
                        </button>
                    </Link>
                </div>
            </form>
        </div>

    );

}

export default Login;