import React, {useState} from "react"
// import {Link} from 'react-router-dom'
import {FaBars, FaTimes} from 'react-icons/fa' 
import Logo from '../../images/logo1.png'
import { Navbar, Nav, Container, Form, Button } from 'react-bootstrap';
//import Navbar from 'react-bootstrap/Navbar';
import LoginForm from '../login-form/LoginForm';
import RegistrationForm from '../registration-form/RegistrationForm';
import './NavegationBar.scss'


const NavegationBar = () => {
    // const [click, setClick] = useState(false);
    // const handleClick = () => setClick(!click);
    const [showLogin, setShowLogin] = useState(false);
    const [showRegistration, setShowRegistration] = useState(false);
    
    const handleShowLogin = () => setShowLogin(true);
    const handleShowRegistration = () => setShowRegistration(true);

    return (
        <Container fluid>
        <Navbar bg="dark" variant="dark" expand="md" fixed="top" collapseOnSelect>
            <Container fluid>
                <Navbar.Brand href="#home">
                    <img alt="" src={Logo} className="d-inline-block align-top" />
                    {' '}
                    <h1>FoodApp</h1>
                </Navbar.Brand>
                <Navbar.Toggle aria-controls="navbarCollapse" />
                <Navbar.Collapse id="navbarCollapse" className="justify-content-end">
                    <Nav
                        className="me-auto my-2 my-lg-0"
                        //style={{ maxHeight: '100px' }}
                        //navbarScroll
                    >  
                        <Nav.Link href="#">Home</Nav.Link>
                        <Nav.Link href="#">Menus</Nav.Link>
                        <Nav.Link href="#">About</Nav.Link>
                        <Nav.Link href="#" onClick={handleShowRegistration}>Register</Nav.Link>
                        <Nav.Link href="#" onClick={handleShowLogin}>Login</Nav.Link>
                    </Nav>  
                    <Form className="d-flex">
                        <Form.Control
                            type="search"
                            placeholder="Search"
                            className="me-2"
                            aria-label="Search"
                        />
                        <Button variant="outline-success">Search</Button>
                    </Form>
                </Navbar.Collapse>           
            </Container>
        </Navbar>
        <LoginForm showLogin={ showLogin } setShowLogin={ setShowLogin }/>
        <RegistrationForm showRegistration={ showRegistration } setShowRegistration={ setShowRegistration }/>
        </Container>



    )
}

export default NavegationBar;