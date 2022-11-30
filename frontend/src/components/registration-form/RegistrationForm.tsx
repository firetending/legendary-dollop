import React, {useState} from "react";
// import {Link} from 'react-router-dom';
import {FaBars, FaTimes, FaFacebook, FaGoogle, FaUniversity} from 'react-icons/fa';
import './RegistrationForm.scss';
import { Modal, Button, Form, Container, Row, Col, Alert} from 'react-bootstrap';
import doAxiosFetch from '../../utils/doAxiosFetch';
import { capitalizeFirstCharacter } from "../../utils/stringTools";
 

const RegistrationForm = ({ showRegistration, setShowRegistration }: {showRegistration: boolean; setShowRegistration: any}) => {
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [verifyPassword, setVerifyPassword] = useState("");
    const [hasError, setHasError] = useState(false);
    const [axiosResponseData, setAxiosResponseData] = useState<any>(null);


    const handleClose = () => { setShowRegistration(false) };    
    const handleRegistration = async (event: React.FormEvent<HTMLButtonElement>) => {
        console.log("Starting Registration Call...");
        event.preventDefault();   
        
        console.log("First Name: " + firstName);
        console.log("Last Name: " + lastName);
        console.log("Password: " + password);
        console.log("Verify: " + verifyPassword);
        
        doAxiosFetch({
                method: "POST",
                url: "http://localhost:8081/api/v1/registration/register", 
                headers: {
                    'content-type': 'application/json'                
                }, 
                data: {
                    "firstName": firstName,
                    "lastName": lastName,
                    "email": email,
                    "password": password,
                    "verifyPassword": verifyPassword
                },
                
        }).then((result: any) => { 
            console.log('Result: ' + JSON.stringify(result));

            const data = result.data;
            setAxiosResponseData(data);
            if(data === null || data['statusCode'] !== 200){                
                setHasError(true); 
            } else {
                // set access token
                setShowRegistration(false);
            }              
            console.log('Done!');   
        });             
    };


    //data.data.errors[0].code.replaceAll('.', ' ')

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
                                            <Form.Control 
                                                type="text" 
                                                placeholder="Enter First Name" 
                                                value={firstName} 
                                                onChange={ (event) => setFirstName(event.target.value) }
                                                required
                                            />                                                            
                                        </Form.Group>
                                    </Col>
                                    <Col md="6">
                                        <Form.Group className="mb-3" controlId="formLastName">
                                            <Form.Label>Last Name</Form.Label>
                                            <Form.Control 
                                                type="text" 
                                                placeholder="Enter Last Name" 
                                                value={lastName} 
                                                onChange={ (event) => setLastName(event.target.value) }
                                                required
                                            />                                                            
                                        </Form.Group>   
                                    </Col>                             
                                </Row>

                                <Row>  
                                    <Col>              
                                    <Form.Group className="mb-3" controlId="formBasicEmail">
                                        <Form.Label>Email address</Form.Label>
                                        <Form.Control 
                                            type="email" 
                                            placeholder="Enter email" 
                                            value={email} 
                                            onChange={ (event) => setEmail(event.target.value) }
                                            required
                                        />                                                            
                                    </Form.Group>
                                </Col> 
                                </Row>  
                            
                                <Row>
                                    <Col md="6">
                                        <Form.Group className="mb-3" controlId="formPassword">                                  
                                            <Form.Label>Password</Form.Label>
                                            <Form.Control 
                                                type="password" 
                                                placeholder="Password" 
                                                value={password} 
                                                onChange={ (event) => setPassword(event.target.value) }
                                                required
                                            />
                                        </Form.Group> 
                                    </Col>
                                    <Col md="6">
                                        <Form.Group className="mb-3" controlId="formVerifyPassword">                                  
                                            <Form.Label>Confirm Password</Form.Label>
                                            <Form.Control 
                                                type="password" 
                                                placeholder="Re-type Password" 
                                                value={verifyPassword} 
                                                onChange={ (event) => setVerifyPassword(event.target.value) }
                                                required
                                            />
                                        </Form.Group> 
                                    </Col>
                                </Row>
                                <Row>
                                    { hasError &&                                 
                                        <Col>
                                            <Alert variant="danger" onClose={() => setHasError(false)} dismissible>
                                                <Alert.Heading>
                                                    {
                                                        axiosResponseData !== null && axiosResponseData.data !== null &&
                                                        <>{axiosResponseData.message}</>
                                                    }
                                                </Alert.Heading>
                                                <p>
                                                    {
                                                        axiosResponseData !== null && axiosResponseData.data !== null &&
                                                        axiosResponseData.data.errors.map((error: any) => { 
                                                            const message = error.defaultMessage.replaceAll('.', ' ');                                                    
                                                            return <><span key={ Math.random() * 10}><b>{ capitalizeFirstCharacter(error.field)}</b> { ':  ' + capitalizeFirstCharacter(message) }</span><br/></>;
                                                        })
                                                    }
                                                </p>
                                                
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

                        <Button variant="primary" onSubmit={ (event) => false } onClick={handleRegistration} type="submit" size="sm">
                            Register
                        </Button>
                    </Modal.Footer>  
                </Form>              
            </Modal>
        </>
    );
}

export default RegistrationForm;