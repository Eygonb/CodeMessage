import React from 'react';
import "../adminTable.css"
const data = [
    {id:1, user_id: 2, reason: "shaming"},
    {id:2, user_id: 4, reason: "shaming"},
    {id:3, user_id: 5, reason: "shaming"},
]

//reports
// id uuid default uuid_generate_v4() not null,
//     user_id uuid not null,
//     reason text not null,


const ReportList = (props) => {
    if (!props.show){
        return null
    }
    return (
        <div className="userList-box">

            <table>
                <tr>
                    <th>id</th>
                    <th>user_id</th>
                    <th>reason</th>

                </tr>
                {data.map((val, key) => {
                    return (
                        <tr key={key}>
                            <th>{val.id}</th>
                            <th>{val.user_id}</th>
                            <th>{val.reason}</th>
                        </tr>
                    )
                })}
            </table>
            <button onClick={props.onClose}>Close</button>
        </div>
    );
}

export default ReportList;