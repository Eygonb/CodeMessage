import React, {useState} from "react";
import './Login.css';
import '../../index.css';
import {Link, Navigate} from "react-router-dom";
import {useForm, Controller } from "react-hook-form";

import {
    TextField,
} from "@mui/material/";
import api from "./services";
import useAuth from "./loginUtils/useAuth";

function Login() {
    const [isLoading, setIsLoading] = useState(false);

    const {
        control,
        handleSubmit,
        formState: {errors},
        setError,
    } = useForm({});

    const auth = useAuth();

    const onSubmit = async (data) => {
        try {
            setIsLoading(true);
            const {data: loginData} = await api.auth.login(data);
            auth.setToken(loginData);
            const {data: loginData2} = await api.auth.getProfile();
            auth.setUser(loginData2);
            // auth.setToken(loginData);
            // console.log(loginData)
        } catch (e) {
            if (e.response.status === 401) {
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

    return auth.user ? (
        <Navigate
            to={{
                pathname: "/"
            }}
        />):(
        <div className="messenger">
            {console.log(auth)}
            <form onSubmit={handleSubmit(onSubmit)}>
                <div className="login-box">
                    <span className="text-center">login</span>
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
                                    error={Boolean(errors.email?.message)}
                                    fullWidth={true}
                                    label="username"
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
                                    id="standard-basic2"
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
                            variant="contained"
                            color="primary"
                            type="submit"
                            disabled={isLoading}
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