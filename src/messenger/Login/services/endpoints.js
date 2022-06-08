import axios from "./axios";

const endpoints = {
    registration: (data) => axios.post("/accounts/register", data),
    login: (data) => axios.post("/authenticate", data),

    // forgotPassword: (data) => axios.post("/v1/auth/forgot/password", data),
    getProfile: () => axios.get("/accounts/me"),
    // updateProfile: (data) => axios.patch("/v1/auth/me", data),
    getChatsListBySearch: (data, page, size, search) => axios.get("/chats?", data),
    getChatsList: (data, page, size) => axios.get("/chats?page=" + page + "&size=" + size),
    getChatByID: (data, id) => axios.get("/chats/", id),
    getMessagesInChat:
        (data, chat_id, page, size) => axios.get("/messages/chats/"+ chat_id+"?page="+page+"&size="+size),
    postMessage: (data) => ("/chats", data),
    newChat: (data, id, chatName, users,) => axios.post("/chats/", id),
};

export default endpoints;