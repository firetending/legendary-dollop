import React, { useState, useEffect, useContext } from "react";
// import {Link} from 'react-router-dom';
import {FaBars, FaTimes} from 'react-icons/fa';
import Logo from '../../images/logo1.png';
import { Navbar, Nav, Container, Form, Button, Dropdown } from 'react-bootstrap';
import { GlobalContext } from '../../context/GlobalState';
import LoginForm from '../login-form/LoginForm';
import RegistrationForm from '../registration-form/RegistrationForm';
import { isEmpty } from "../../utils/extraTools";
import './NavegationBar.scss';


const NavegationBar = () => {
    const { resetLoginData, globalAppData } = useContext<any>(GlobalContext);
    console.log("NAV-globalAppData: " + JSON.stringify(globalAppData));

    const [showLogin, setShowLogin] = useState(false);
    const [showRegistration, setShowRegistration] = useState(false);  
    const [user, setUser] = useState<any>({});  
    
    const handleShowLogin = () => setShowLogin(true);
    const handleShowRegistration = () => setShowRegistration(true);
    
    const handleLogout = async () => {
        console.log('Good Bye!');
        await resetLoginData();
        setUser({});
    }

    

    useEffect(() => {
        
        setUser(
            ( 
                !isEmpty(globalAppData)
                && !isEmpty(globalAppData.loginData) 
                && !isEmpty(globalAppData.loginData.data) 
                && !isEmpty(globalAppData.loginData.data.user)
            )?
                globalAppData.loginData.data.user
                : {}
        );
        console.log('User: ' + JSON.stringify(user));
    }, [globalAppData]);

    return (
        <Container fluid>
        <Navbar bg="dark" variant="dark" expand="md" fixed="top" collapseOnSelect>
            <Container fluid>
                <Navbar.Brand href="/home">
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
                        <Nav.Link href="/home">Home</Nav.Link>
                        <Nav.Link href="/main">Menus</Nav.Link>
                        <Nav.Link href="/about">About</Nav.Link>
                        <Nav.Link href="#" onClick={handleShowRegistration}>Register</Nav.Link>
                        <Nav.Link href="#" onClick={handleShowLogin}>Login</Nav.Link>
                        
                    </Nav> 
                    { 
                        (!isEmpty(user)) &&
                            <Dropdown 
                                className="d-inline mx-2" 
                                id="user-dropdown"
                                
                            >
                                <Dropdown.Toggle id="user-dropdown-menu" variant="dark">
                                    {                                         
                                        user.firstName + ' ' + user.lastName  
                                    }
                                </Dropdown.Toggle>

                                <Dropdown.Menu variant="dark">
                                    <Dropdown.Item href="#">Profile</Dropdown.Item>
                                    <Dropdown.Item href="#">Security</Dropdown.Item>
                                    <Dropdown.Divider />
                                    <Dropdown.Item href="#" onClick={handleLogout}>Logout</Dropdown.Item>
                                </Dropdown.Menu>
                            </Dropdown>
                        
                    }                    
                    
                </Navbar.Collapse>           
            </Container>
        </Navbar>
        <LoginForm showLogin={ showLogin } setShowLogin={ setShowLogin }/>
        <RegistrationForm showRegistration={ showRegistration } setShowRegistration={ setShowRegistration }/>
        </Container>



    )
}

export default NavegationBar;