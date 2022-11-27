import React, {useState} from "react"
// import {Link} from 'react-router-dom'
import {FaBars, FaTimes} from 'react-icons/fa' 
import Logo from '../../images/FoodApp.png'
import { Navbar, Nav, Container, Form, Button } from 'react-bootstrap';
//import Navbar from 'react-bootstrap/Navbar';
import './NavegationBar.scss'


const NavegationBar = ({ setShowLogin }: { setShowLogin: any }) => {
    const [click, setClick] = useState(false);
    const handleClick = () => setClick(!click);

    
    const handleShow = () => setShowLogin(true);

    return (
        <Container>
        <Navbar bg="dark" variant="dark" expand="md" fixed="top" collapseOnSelect>
            <Container fluid>
                <Navbar.Brand href="#home">
                    <img alt="" src={Logo} width="30" height="30" className="d-inline-block align-top" />
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
                        <Nav.Link href="#">Register</Nav.Link>
                        <Nav.Link href="#" onClick={handleShow}>Login</Nav.Link>
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
        </Container>




        // <div className='navbar'>
        //     <div className='logo'>
        //         <img src={Logo} alt='logo' />
        //     </div>
        //     <ul className={click ? 'nav-menu active' : 'nav-menu'}>
        //         <li className='nav-item'><a href='#'>Home</a></li>
        //         <li className='nav-item'><a href='#'>Menus</a></li>
        //         <li className='nav-item' onClick={handleShow}><a href='#'>Log In</a></li>
        //         <li className='nav-item'><a href='#'>About Us</a></li>
        //     </ul>
        //     <div className="hamburger" onClick={handleClick}>
        //         {click ? (<FaTimes size={30} style={{color: '#f8f8f8'}} />) : (<FaBars size={30} style={{color: '#f8f8f8'}} />)}                
        //     </div>
        // </div>
    )
}

export default NavegationBar;