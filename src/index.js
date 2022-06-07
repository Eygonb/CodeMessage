import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import 'bootstrap/dist/css/bootstrap.min.css';
import {BrowserRouter as Router} from "react-router-dom";
import AuthProvider from "./Providers/AuthProvider";


ReactDOM.render(
    <React.StrictMode>
        <AuthProvider>
            <Router>
                <App/>
            </Router>
        </AuthProvider>
    </React.StrictMode>,


    document.getElementById('root')
);

