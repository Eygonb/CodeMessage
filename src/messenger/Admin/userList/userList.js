import React from 'react';
import "../adminTable.css"
const data = [
    {id:1, username: "Jessie Holt", email: "jessie.holt@example.com", password: "password", type: "2",
        title: "Hi, My name is Jessie Holt", img_id: "https://randomuser.me/api/portraits/men/43.jpg"},
    {id:2, username: "Wyatt Holmes", email: "wyatt.holmes@example.com", password: "password", type: "1",
        title: "Hi, My name is Wyatt Holmes", img_id: "https://randomuser.me/api/portraits/men/44.jpg"},
    {id:3, username: "Christine Bradley", email: "christine.bradley@example.com", password: "password", type: "3",
        title: "Hi, My name is Christine Bradley", img_id: "https://randomuser.me/api/portraits/women/45.jpg"},
]

// id uuid default uuid_generate_v4() not null,
//     username text not null,
//     email text not null,
//     password text not null,
//     type text not null,
//     title text,
//     img_id uuid,


const UserList = (props) => {
    if (!props.show){
        return null
    }
    return (
        <div className="userList-box">
            <table>
                <tr>
                    <th>id</th>
                    <th>img_id</th>
                    <th>Username</th>
                    <th>Email</th>
                    <th>password</th>
                    <th>type</th>
                    <th>title</th>
                    <th/>
                </tr>
                {data.map((val, key) => {
                    return (
                        <tr key={key}>
                            <th>{val.id}</th>
                            <th><img src={val.img_id} className="rounded-circle user_img"/></th>
                            <th>{val.username}</th>
                            <th>{val.email}</th>
                            <th>{val.password}</th>
                            <th>{val.type}</th>
                            <th>{val.title}</th>
                            <th><button type="button" >
                                Make Admin
                            </button></th>
                        </tr>
                    )
                })}
            </table>
            <button className="closeButton" onClick={props.onClose}>Close</button>
        </div>
    );
}

export default UserList;