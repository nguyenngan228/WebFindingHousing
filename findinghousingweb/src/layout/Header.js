
import { useContext } from "react";
import { Container, Image, Nav,  Navbar} from "react-bootstrap";
import { Link } from "react-router-dom";
import { MyUserContext } from "../configs/Contexts";

const Header = () =>{
    const user = useContext(MyUserContext);
    return(<>
        <Navbar expand="lg" className="bg-body-tertiary">
        <Container>
            <Navbar.Brand href="#home">Hỗ trợ tìm trọ</Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav" />
            <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
                {user===null?<>
                    <Link to="/register" className="nac-link nav-success">Đăng ký</Link>
                <Link to="/login" className="nac-link text-bg-info">Đăng nhập</Link>
                </>:<>
                <Link to="/" className="nac-link nav-success">
                    <Image src={user.avatar} width="40" className="rounded-circle"/>{user.username}
                </Link>
                <Link to="/logout">Dang xuat</Link>
                </>}
                
                
            </Nav>
            </Navbar.Collapse>
        </Container>
        </Navbar>
    
    </>)
}

export default Header;