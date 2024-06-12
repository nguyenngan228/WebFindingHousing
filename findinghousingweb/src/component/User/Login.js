import { useContext, useState } from "react";
import { Button, Container, Form } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import Apis, { authApi, endpoints } from "../../configs/Apis";
import cookies from 'react-cookies'
import cookie from 'react-cookies'
import { MyDispatchContext } from "../../configs/Contexts";

const Login = ()=>{
    const fields=[{
        label:"Tên đăng nhập",
        type: "text",
        field: "username"
    },{
        label:"Mật khẩu",
        type: "password",
        field: "password"
    }];
    const [user, setUser] = useState({});
    const nav=useNavigate();
    const dispatch = useContext(MyDispatchContext);
    


    const change =(e,field)=>{
        setUser(current=>{
            return{...current,[field]:e.target.value}
        })

    }

    const login=async(e)=>{
        e.preventDefault();
        try{
            let res=await Apis.post(endpoints['login'],{...user})
            console.info(res.data)
            cookies.save("token",res.data)
            let u = await authApi().get(endpoints['current-user']);
            cookie.save('user',u.data);
            dispatch({
                "type":"login",
                "payload":u.data
            });
            nav("/")

        }catch(ex){
            console.error(ex)
        }
    }

    return(
        <Container>
            <h1>Dang nhap nguoi dung</h1>
            <Form onSubmit={login}>
                {fields.map(f=><Form.Group key={f.field} className="mb-3" controlId={f.field}>
                    <Form.Label>{f.label}</Form.Label>
                    <Form.Control onChange={e=>change(e,f.field)} value={user[f.field]} type={f.type} placeholder={f.label} />
                </Form.Group>)}
               
                <Form.Group className="mb-3" >
                    <Button type="submit" variant="primary">Đăng nhap</Button>
                </Form.Group>

            </Form>
        </Container>
    )
}
export default Login;