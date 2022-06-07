import React from "react";
import Login from "./Login/Login";

const PrivateRoute = ({children, authenticated}) => {

    return authenticated === true ? children : <Login/>
};

export default PrivateRoute;