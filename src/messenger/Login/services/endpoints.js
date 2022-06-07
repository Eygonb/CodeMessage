import axios from "./axios";

const endpoints = {
    registration: (data) => axios.post("/accounts/register", data),
    login: (data) => axios.post("/authenticate", data),

    // forgotPassword: (data) => axios.post("/v1/auth/forgot/password", data),
    getProfile: () => axios.get("/accounts/me"),
    // updateProfile: (data) => axios.patch("/v1/auth/me", data),
};

export default endpoints;