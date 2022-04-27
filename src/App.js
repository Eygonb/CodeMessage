import Home from "./messenger/Home";
import {Route, Routes} from "react-router-dom";
import Settings from "./messenger/Settings/Settings";
import Login from "./messenger/Login/Login";
import Register from "./messenger/Login/Register";

function App() {
    return (
        <div className="messenger">

            <Routes>
                <Route path="/" element={<Home/>}/>
                <Route path="/settings" element={<Settings/>}/>
                <Route path="/login" element={<Login/>}/>
                <Route path="/register" element={<Register/>}/>
            </Routes>

            <Home/>

            {/*<Settings/>*/}
            {/*<Login/>*/}
            {/*<Register/>*/}

        </div>
    )
}

export default App;
