import React from "react";
import './chat.css'

const PopupConv = props => {

    return (
        <div className="action_menu">
            <ul>
                <li><i className="fa fa-user-circle"></i> View profile</li>
                <li><i className="fa fa-users"></i> Add to close friends</li>
                <li><i className="fa fa-plus"></i> Add to group</li>
                <li><i className="fa fa-ban"></i> Block</li>
            </ul>
        </div>
    )
}

export default PopupConv;