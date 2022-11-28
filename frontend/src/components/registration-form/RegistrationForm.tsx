import React, {useState} from "react";
// import {Link} from 'react-router-dom';
import {FaBars, FaTimes, FaFacebook, FaGoogle, FaUniversity} from 'react-icons/fa';
import './RegistrationForm.scss';
import { Modal, Button, Form, Container, Row, Col } from 'react-bootstrap';
import useAxiosFetch from '../../hooks/useAxiosFetch';


const RegistrationForm = ({ showRegistration, setShowRegistration }: {showRegistration: boolean; setShowRegistration: any}) => {
    const [ data, error, loaded, doAxiosFetch ] = useAxiosFetch(
        {
            method: "POST",
            url: "auth/login",
            headers: {
                'content-type': 'application/json'                
            }, 
            data: {
                "email": "admin@hello.com",
                "password": "password"
            }
        },
    );


    const handleClose = () => { setShowRegistration(false) };
    const handleRegistration = async () => {
        console.log("Starting Registration Call...");
        doAxiosFetch();
        //setShowRegistration(false);
        console.log("Done!");        
    };

    return (
        <>
            <Modal  
                show={showRegistration} 
                onHide={handleClose} 
                centered
                size='lg'
                fullscreen='false'
                animation
            >                
                <Modal.Header closeButton>
                    <Modal.Title>Register New Account:</Modal.Title>
                </Modal.Header>
                <Form>
                    <Modal.Body>  
                            <Container fluid> 
                                <Row>  
                                    <Col md="6">
                                        <Form.Group className="mb-3" controlId="formFistName">
                                            <Form.Label>First Name</Form.Label>
                                            <Form.Control type="text" placeholder="Enter First Name" required/>                                                            
                                        </Form.Group>
                                    </Col>
                                    <Col md="6">
                                        <Form.Group className="mb-3" controlId="formLastName">
                                            <Form.Label>Last Name</Form.Label>
                                            <Form.Control type="text" placeholder="Enter Last Name" required/>                                                            
                                        </Form.Group>   
                                    </Col>                             
                                </Row>

                                <Row>  
                                    <Col>              
                                    <Form.Group className="mb-3" controlId="formBasicEmail">
                                        <Form.Label>Email address</Form.Label>
                                        <Form.Control type="email" placeholder="Enter email" required/>                                                            
                                    </Form.Group>
                                </Col> 
                                </Row>  
                            
                                <Row>
                                    <Col md="6">
                                        <Form.Group className="mb-3" controlId="formPassword">                                  
                                            <Form.Label>Password</Form.Label>
                                            <Form.Control type="password" placeholder="Password" required/>
                                        </Form.Group> 
                                    </Col>
                                    <Col md="6">
                                        <Form.Group className="mb-3" controlId="formVerifyPassword">                                  
                                            <Form.Label>Confirm Password</Form.Label>
                                            <Form.Control type="password" placeholder="Password" required/>
                                        </Form.Group> 
                                    </Col>
                                </Row>
                            </Container>
                            
                    </Modal.Body>
                    <Modal.Footer>
                        <Button variant="secondary" onClick={handleClose} size="sm">
                            Cancel
                        </Button>

                        <Button variant="primary" onClick={handleRegistration} type="submit" size="sm">
                            Register
                        </Button>
                    </Modal.Footer>  
                </Form>              
            </Modal>
        </>
    );
}

export default RegistrationForm;