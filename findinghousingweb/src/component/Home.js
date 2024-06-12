import { useEffect, useState } from "react";
import { Spinner } from "react-bootstrap";
import Apis, { authApi, endpoints } from "../configs/Apis";
import MySpinner from "../layout/MySpinner";

const Home = ()=>{
    const [posts, setPost] = useState(null);
    const loadPost = async()=>{
        let res = await Apis.get(endpoints['posts'])
        setPost(res.data);
    }
    useEffect(()=>{
        loadPost();
    },[])
    if(posts===null)
        return <MySpinner/>
    return(
        <ul>
            {posts.map(c=><li key={c.id}>{c.name}</li>)}
        </ul>
    )
}
export default Home;