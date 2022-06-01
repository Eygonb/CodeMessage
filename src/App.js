import Home from "./messenger/Home";
import {Route, Routes} from "react-router-dom";
import Settings from "./messenger/Settings/Settings";
import Login from "./messenger/Login/Login";
import Register from "./messenger/Login/Register";
import UserProfile from "./messenger/Profile/Profile";
import Admin from "./messenger/Admin/Admin";

function App() {
    return (
        <div className="body">
            <Routes>
                <Route path="/" element={<Home/>}/>
                <Route path="/settings" element={<Settings/>}/>
                <Route path="/profile" element={<UserProfile/>}/>
                <Route path="/login" element={<Login/>}/>
                <Route path="/register" element={<Register/>}/>
                <Route path="/admin" element={<Admin/>}/>
            </Routes>
            {/*<Home/>*/}
        </div>
    )
}

export default App;
