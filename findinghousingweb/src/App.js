import { BrowserRouter, Route, Routes } from "react-router-dom";
import Footer from "./layout/Footer";
import Home from "./component/Home";
import 'bootstrap/dist/css/bootstrap.min.css';
import Header from "./layout/Header";
import Register from "./component/User/Register";
import Login from "./component/User/Login";
import { MyDispatchContext, MyUserContext } from "./configs/Contexts";
import { useReducer } from "react";
import MyUserReducer from "./configs/Reducer";
import cookie from 'react-cookies'

const App = () =>{
  const [user, dispatch]=useReducer(MyUserReducer,cookie.load("user")||null);
  return(
    <>
      <BrowserRouter>
        <MyUserContext.Provider value={user}>
          <MyDispatchContext.Provider value={dispatch}>
            <Header/>
              <Routes>
                <Route path="/" element={<Home/>}/>
                <Route path="/register" element={<Register/>}/>
                <Route path="/login" element={<Login/>}/>
              </Routes>
          <Footer/>
          </MyDispatchContext.Provider>
        </MyUserContext.Provider>
      </BrowserRouter>
    </>
  )

}
export default App;