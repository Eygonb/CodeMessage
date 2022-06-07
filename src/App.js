import Home from "./messenger/Home";
import {Route, Routes} from "react-router-dom";
import Settings from "./messenger/Settings/Settings";
import Login from "./messenger/Login/Login";
import Register from "./messenger/Login/Register";
import UserProfile from "./messenger/Profile/Profile";
import Admin from "./messenger/Admin/Admin";
import React, {Component, useEffect, useState} from "react";
import PrivateRoute from "./messenger/privateRoute";

function App() {
    const [username, setUsername] = useState('')
    const [isLoggedIn, setIsLoggedIn] = useState(false)


        return(
        <div className="body">
            <Routes>
                {/*неприватные*/}
                <Route path="/login"
                       element={<Login isLoggedIn ={isLoggedIn => setIsLoggedIn(isLoggedIn)}/>}

                />

                <Route path="/register"
                       element={<Register/>}
                />

                {/*приватные*/}
                <Route path="/" element={<PrivateRoute authenticated={isLoggedIn}>
                    <Home/></PrivateRoute>}/>
                <Route path="/settings" element={<PrivateRoute authenticated={isLoggedIn}>
                    <Settings/></PrivateRoute>}/>
                <Route path="/profile" element={<PrivateRoute authenticated={isLoggedIn}>
                    <UserProfile/></PrivateRoute>}/>
                <Route path="/admin" element={<PrivateRoute authenticated={isLoggedIn}>
                    <Admin/></PrivateRoute>}/>
            </Routes>
            {/*<Home/>*/}
        </div>
        )

}

export default App;
