import Home from "./messenger/Home";
import {Route, Routes} from "react-router-dom";
import Settings from "./messenger/Settings/Settings";
import Login from "./messenger/Login/Login";
import Register from "./messenger/Login/Register";
import UserProfile from "./messenger/Profile/Profile";
import Admin from "./messenger/Admin/Admin";
import React, {Component, useEffect, useState} from "react";
// import PrivateRoute from "./messenger/privateRoute";
import PrivateRoute from "./customRouters/PrivateRoute";
import useAuth from "./messenger/Login/loginUtils/useAuth";

function App() {
    const [username, setUsername] = useState('')
    const [isLoggedIn, setIsLoggedIn] = useState(false)
    const auth = useAuth();

        return auth.isLoaded ?(
        <div className="body">
            <Routes>
                {/*неприватные*/}
                <Route path="/login" element={<Login/>}/>

                <Route path="/register" element={<Register/>}/>

                {/*приватные*/}
                <Route path="/" element={<PrivateRoute>
                    <Home/></PrivateRoute>}/>
                <Route path="/settings" element={<PrivateRoute>
                    <Settings/></PrivateRoute>}/>
                <Route path="/profile" element={<PrivateRoute>
                    <UserProfile/></PrivateRoute>}/>
                <Route path="/admin" element={<PrivateRoute >
                    <Admin/></PrivateRoute>}/>
            </Routes>

            {/*TODO 404 СТРАНИЧКУ*/}
            {/*<Route path="/not-found-404" element={<NotFound />} />*/}
            {/*<Route path="*" element={<Navigate to="/not-found-404" />} />*/}
            {/*<Home/>*/}
        </div>
        ) : (
            <div className="body">
                <h1>Загрузка</h1>
            </div>
        )

}

export default App;
