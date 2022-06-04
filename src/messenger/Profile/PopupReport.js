import React from "react";
import '../chat/popup-styles.css'

const PopupReport = (props) => {
    if (!props.show) {
        return null
    }
    return (
        <div className="action_menu-box" onClick={props.onClose}>
            <div className="report" onClick={e => e.stopPropagation()}>
                <ul>
                    <li><h4>Отправить жалобу</h4></li>
                    <li><textarea name="" className="form-control type_msg"
                                  placeholder="Введите жалобу"></textarea></li>
                    <li>
                        <button type="button" className="report-button" onClick={props.onClose}> Отправить</button>
                    </li>
                </ul>
            </div>
        </div>
    )
}

export default PopupReport;