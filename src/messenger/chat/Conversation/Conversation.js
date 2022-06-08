import React, {useState, useEffect} from 'react';
import './chat.css'
import PopupConv from "./PopupConv";
import ConversationItem from "./ConversationItem/ConversationItem";
import Cookies from "js-cookie";
import api from "../../Login/services";
import {Form} from "react-bootstrap";
import {useForm, Controller } from "react-hook-form";
import {TextField} from "@mui/material";

export default function Conversation(props) {
    const [isOpen, setIsOpen] = useState(false);
    let selectedChat = localStorage.getItem("selectedChat")
    const [status, setStatus] = useState('')
    const [isLoading, setIsLoading] = useState(false);

    let myID = localStorage.getItem("logginUserId")
    const [messagesList, setMessagesList] = useState([]);
    const [token, setTokenData] = useState(null);
    const togglePopup = () => {
        setIsOpen(!isOpen);
    }
    const {imgId, chatName, chatId} = props.data;

    const getConversations = (page, size) => {
        const tokenData = Cookies.get("auth-token");
        setTokenData(tokenData);
        const requestOptions = {
            headers: {
                'Content-Type': 'application/json'
            }
        };

        api.auth.getMessagesInChat(requestOptions, selectedChat, page, size)
            .then(function (response) {
                console.log(response.data);
                setMessagesList([...messagesList, ...response.data])
            });
    }

    const [currentPage, setCurrentPage] = useState(0)
    const [fetching, setFetching] = useState(true)

    useEffect(() => {
        if (fetching) {
            getConversations(0, 19)
        }
    }, [fetching])

    useEffect(() => {
        document.addEventListener("scroll", scrollHandler)

        return function () {
            document.removeEventListener("scroll", scrollHandler)
        }
    }, [])

    const scrollHandler = (e) => {
        console.log("scrolHeight", e.target.documentElement.scrollHeight)
        console.log("scrolTop", e.target.documentElement.scrollTop)
        console.log("innerHeight", window.innerHeight)
    }


    const sendData = async (data)  => {
        let mes = ''+data.message
        console.log(mes)


        const requestOptions = {

            method: "POST",
            headers: {
                'Authorization': 'Bearer ' + token,
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                textMsg: data.message,
                chatId: selectedChat,
                type: "USERS"
            })
        };
        await fetch("http://localhost:8080/chats", requestOptions).then(response => { console.log(response)});
    }

    const handleChange = (event) => {
        setStatus(event.target.value)
    }
    const {
        control,
        handleSubmit,
        formState: {errors},
        setError,
    } = useForm({});

    return (
        <div className="container">
            <div className="col-md-8 col-xl-6">
                <div className="card-box">
                    <div className="card chat">
                        <div className="card-header msg_head">
                            <div className="d-flex bd-highlight">
                                <div className="img_cont">
                                    <img src={imgId} className="rounded-circle user_img" alt='userLogo'/>
                                    <span className="online_icon"></span>
                                </div>
                                <div className="user_info">

                                    <h6>{chatName}</h6>
                                    <div className='conv-status'>Online</div>
                                </div>
                            </div>
                            <span id="action_menu_btn" onClick={togglePopup}>
                            <i className="fa fa-ellipsis-v"></i>
                        </span>
                        </div>
                        {isOpen && <PopupConv data={props.data} handleClose={togglePopup}/>}
                        <div className="card-body msg_card_body">

                            {messagesList.map((message) => {

                                    return (
                                        <ConversationItem
                                            messages={message}
                                            imgId={imgId}
                                            myID={myID}
                                            key={message.mes_id}/>)
                                }
                            )}
                        </div>

                        <div className="card-footer">
                            <div className="input-group">
                                <div className="input-group-append">
                                <span className="input-group-text attach_btn"><i
                                    className="fa fa-paperclip"></i></span>
                                </div>
                                <Form onSubmit={handleSubmit(sendData)}>
                                    <Controller
                                        name="message"
                                        control={control}
                                        defaultValue=""
                                        render={({ field }) => (
                                            <TextField
                                                {...field}
                                                error={Boolean(errors.password?.message)}
                                                type="password"
                                                fullWidth={true}
                                                label="Password"
                                                variant="filled"
                                                className="form-control type_msg"
                                                placeholder="Type your message..."
                                                helperText={errors.password?.message}
                                            />
                                        )}
                                    />


                                <div className="input-group-append">

                                    <button
                                        className="input-group-text send_btn"
                                        type ="submit"
                                        variant="contained"
                                        color="primary"
                                        disabled={isLoading}
                                    >
                                    <i className="fa fa-location-arrow"></i>
                                    </button>


                                </div>
                                </Form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    );
}