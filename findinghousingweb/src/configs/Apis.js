import axios from "axios"
import cookie from 'react-cookies'
const SERVER_CONTEXT = "/WebFindingHousing";
const BASE_URL = "http://localhost:8080"

export const endpoints={
    "posts":`${SERVER_CONTEXT}/api/posts/`,
    "register":`${SERVER_CONTEXT}/api/users/`,
    "login":`${SERVER_CONTEXT}/api/login/`,
    "current-user":`${SERVER_CONTEXT}/api/current-user/`
}
export const authApi = ()=>{
    return axios.create({
        baseURL: `${BASE_URL}`,
        headers:{
            'Authorization':`${cookie.load('token')}`
        }
    })
}
export default axios.create({
    baseURL:BASE_URL
})

