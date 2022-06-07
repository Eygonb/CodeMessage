import React, {useState, useEffect, Component} from 'react';
import {NavBar} from "./Navigation/NavBar";
import ChatMenu from "./chat/ChatMenu";

const Home = () => {
    const [userData, setUserData] = useState({firstName: '', lastName: '', email: ''})
    const [active, setActive] = useState(false)
    const [error, setError] = useState('Что-то пошло не так!')
    const [addresses, setAddresses] = useState([])
    const [editData, setEditData] = useState(null)


    return (
        <div className="messenger">
            <NavBar/>
            <ChatMenu/>
        </div>
    );

}
export default Home;