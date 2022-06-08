import {useState, useEffect} from 'react';
import {useForm, Controller } from "react-hook-form";
import React, {Component} from "react";
import './Login.css';
import {Link} from "react-router-dom";
import useAuth from "./loginUtils/useAuth";
import api from "./services";

import {
    TextField,
} from "@mui/material/";

function Register (props){
    const [message, setMessage] = useState('')
    const [isLoading, setIsLoading] = useState(false);
    const auth = useAuth();

    const {
        control,
        handleSubmit,
        formState: {errors},
        setError,
    } = useForm({});

    const onSubmit = async (data) => {
        try {
            setIsLoading(true);
            await api.auth.registration(data);
            const {data: loginData} = await api.auth.login(data);
            auth.setToken(loginData);
            const {data: loginData2} = await api.auth.getProfile();
            auth.setUser(loginData2);
        } catch (e) {
            if (e.response.status === 403) {
                Object.keys(e.response.data.errors).forEach((key) => {
                    setError(key, {
                        type: "manual",
                        message: e.response.data.errors[key],
                    });
                });
            }
        } finally {
            setIsLoading(false);
        }
    };

        return (
            <div className="messenger">
                <form onSubmit={handleSubmit(onSubmit)}>
                    {/*{console.log(auth.login)}*/}
                    <div className="login-box">
                        <span className="text-center">Registration</span>
                        <div className="input-container">
                            <div className="error-text">
                                {message ? message : ''}
                            </div>
                        </div>

                        <div className="input-container">
                            <Controller
                                name="username"
                                control={control}
                                defaultValue=""
                                render={({ field }) => (
                                    <TextField
                                        {...field}
                                        id="standard-basic1"
                                        variant="standard"
                                        error={Boolean(errors.firstName?.message)}
                                        fullWidth={true}
                                        label="Username"
                                        helperText={errors.firstName?.message}
                                    />
                                )}
                            />

                        </div>

                        <div className="input-container">
                            <Controller
                                name="email"
                                control={control}
                                defaultValue=""
                                render={({ field }) => (
                                    <TextField
                                        {...field}
                                        id="standard-basic2"
                                        variant="standard"
                                        error={Boolean(errors.email?.message)}
                                        fullWidth={true}
                                        type="email"
                                        label="Email"
                                        helperText={errors.email?.message}
                                    />
                                )}
                            />
                        </div>

                        <div className="input-container">
                            <Controller
                                name="password"
                                control={control}
                                defaultValue=""
                                render={({ field }) => (
                                    <TextField
                                        {...field}
                                        id="standard-basic3"
                                        variant="standard"
                                        error={Boolean(errors.password?.message)}
                                        type="password"
                                        fullWidth={true}
                                        label="Password"
                                        helperText={errors.password?.message}
                                    />
                                )}
                            />
                        </div>

                        <button className="btn1"
                                variant="primary"
                                type="submit"
                        >submit</button>

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