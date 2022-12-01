import React, {useState} from "react";
// import {Link} from 'react-router-dom';
import {FaBars, FaTimes, FaFacebook, FaGoogle, FaUniversity} from 'react-icons/fa';
import './LoginForm.scss';
import { Modal, Button, Form, Container, Row, Col, Alert, InputGroup } from 'react-bootstrap';
import doAxiosFetch from '../../utils/doAxiosFetch';

const LoginForm = ({ showLogin, setShowLogin }: {showLogin: boolean; setShowLogin: any}) => {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [hasError, setHasError] = useState(false);  
    const [validated, setValidated] = useState(false); 

    const handleClose = () => { setShowLogin(false) };

    const handleSubmit = (event: any) => {
        const form = event.currentTarget;
        event.preventDefault();
        event.stopPropagation();

        if (form.checkValidity() === true) {
            handleLogin();           
        } 
        setValidated(true);        
    };

    const handleLogin = async () => {
        console.log("Starting Login Call...");       
        doAxiosFetch({
                method: "POST",
                url: "http://localhost:8081/api/v1/auth/login", 
                headers: {
                    'content-type': 'application/json'                
                }, 
                data: {
                    "email": email,
                    "password": password
                },
                
        }).then((result: any) => { 
            console.log('Result: ' + JSON.stringify(result));

            const data = result.data;
            if(data === null || data['statusCode'] !== 200){
                setHasError(true); 
            } else {
                // set access token
                setShowLogin(false);
            }   
            console.log('Done!');   
        });             
    };

    return (
        <>
            <Modal  
                show={showLogin} 
                onHide={handleClose} 
                centered
                size='lg'
                fullscreen='false'
                animation
            >                
                <Modal.Header closeButton>
                    <Modal.Title>Login with your Email:</Modal.Title>
                </Modal.Header>
                <Form noValidate validated={validated} onSubmit={handleSubmit}>
                    <Modal.Body>
                        <Container fluid>   
                            <Row>  
                                <Col>           
                                    <Form.Group className="mb-3" controlId="formBasicEmail">
                                        <Form.Label>Email address</Form.Label>
                                        <InputGroup hasValidation>
                                            <InputGroup.Text id="inputGroupPrepend">@</InputGroup.Text>
                                            <Form.Control 
                                                type="email" 
                                                placeholder="Enter email" 
                                                value={email} 
                                                onChange={ (event) => setEmail(event.target.value) }
                                                required
                                            />
                                            <Form.Control.Feedback type="invalid">
                                                Please choose your username (email).
                                            </Form.Control.Feedback>
                                        </InputGroup>                           
                                    </Form.Group>  

                                    <Form.Group className="mb-3" controlId="formPassword">                                  
                                        <Form.Label>Password</Form.Label>
                                        <InputGroup hasValidation>
                                            <Form.Control 
                                                type="password" 
                                                placeholder="Password" 
                                                value={password}
                                                onChange={ (event) => setPassword(event.target.value) }
                                                required
                                            />                                
                                            <Form.Control.Feedback type="invalid">
                                                    Please enter your password.
                                                </Form.Control.Feedback>
                                        </InputGroup>
                                        <Form.Text className="text-muted">
                                            <a href="#">Forgot Password?</a>  
                                        </Form.Text>
                                    </Form.Group>
                                </Col>  
                            </Row>  
                            <Row>
                                { hasError &&                                 
                                    <Col>
                                        <Alert variant="danger" onClose={() => setHasError(false)} dismissible>
                                            <Alert.Heading>Oh snap! You got an error!</Alert.Heading>
                                            <p>Incorrect Credentials</p>
                                        </Alert> 
                                    </Col>                                
                                } 
                            </Row>                            
                        </Container>
                    </Modal.Body>
                    <Modal.Footer> 

                        <Button variant="secondary" onClick={handleClose} size="sm">
                            Cancel
                        </Button>

                        <Button variant="primary" onSubmit={ (event) => false } type="submit" size="sm">
                            Login
                        </Button>

                    </Modal.Footer>  
                </Form>              
            </Modal>            
        </>        
    );
}

export default LoginForm;