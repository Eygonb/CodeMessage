import React, {useState, useEffect} from 'react';
import './chat.css'
import PopupConv from "./PopupConv";
import ConversationItem from "./ConversationItem/ConversationItem";
import Cookies from "js-cookie";
import api from "../../Login/services";
import {Form} from "react-bootstrap";
import {useForm, Controller } from "react-hook-form";
import {TextField} from "@mui/material";
import { useTimer } from 'react-timer-hook';

export default function Conversation(props) {
    const [isOpen, setIsOpen] = useState(false);
    let selectedChat = localStorage.getItem("selectedChat")
    const [isLoading, setIsLoading] = useState(false);

    let myID = localStorage.getItem("logginUserId")
    const [messagesList, setMessagesList] = useState([]);
    const [token, setTokenData] = useState(null);
    const togglePopup = () => {
        setIsOpen(!isOpen);
    }
    const {imgId, chatName, chatId} = props.data;

    const getConversations = (size) => {
        const tokenData = Cookies.get("auth-token");
        setTokenData(tokenData);
        const requestOptions = {
            headers: {
                'Content-Type': 'application/json'
            }
        };
        api.auth.getMessagesInChat(requestOptions, selectedChat, currentPage, size)
            .then(function (response) {
                console.log(response.data);
                setMessagesList([...messagesList, ...response.data])
                setCurrentPage( prevState => prevState +1)
            })
            .finally( () => setFetching(false));
    }

    const [currentPage, setCurrentPage] = useState(0)
    const [fetching, setFetching] = useState(true)
    const [timeLeft, setTimeLeft] = useState(60);

    // useEffect(() => {
    //     if (!timeLeft) {
    //             getConversations(19);
    //         setTimeLeft(180);
    //     }
    //
    //     const intervalId = setInterval(() => {
    //         setTimeLeft(timeLeft - 1);
    //     }, 10);
    //
    //     console.log(timeLeft)
    //     return () => clearInterval(intervalId);
    // }, [timeLeft], [fetching ]);


    useEffect(() => {
        if (fetching) {

            getConversations(19);
            console.log(currentPage)
        }
    }, [fetching ])

    useEffect(() => {
        const scrollContent = document.querySelector('.msg_card_body');

        scrollContent.addEventListener('scroll', () => {
            const scrolled = scrollContent.scrollTop;
            // console.log(scrollContent.scrollHeight);
            if(scrollContent.scrollHeight- (scrolled + window.innerHeight )<100){
                // console.log(scrolled);
                // console.log(window.innerHeight)
                setFetching(true)
            }

        });

    }, [])


    const sendData = async (data)  => {
        console.log(data.message)
        const article = {
            textMsg: data.message,
            chatId: selectedChat
        };
        const requestOptions = {
            method: 'POST',
            headers: {
                'Authorization': 'Bearer ' + token,
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(article
            )
        };
        await fetch("http://localhost:8080/messages", requestOptions).then(response => {
            console.log(response);
            setTimeout(function(){
                window.location.reload();
            }, 3000);
        });
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

                                                fullWidth={true}
                                                label="Enter your message..."
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