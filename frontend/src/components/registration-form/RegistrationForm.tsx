import React, {useState, useEffect} from "react";
// import {Link} from 'react-router-dom';
import {FaBars, FaTimes, FaFacebook, FaGoogle, FaUniversity} from 'react-icons/fa';
import './RegistrationForm.scss';
import { Modal, Button, Form, Container, Row, Col, Alert, InputGroup} from 'react-bootstrap';
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
    const [validated, setValidated] = useState(false);
    const [showConfirmation, setShowConfirmation] = useState(false);

    const handleCloseRegistration = () => { setShowRegistration(false) };  
    const handleCloseConfirmation = () => { setShowConfirmation(false) }; 
    
    const handleSubmit = (event: any) => {
        const form = event.currentTarget;
        event.preventDefault();
        event.stopPropagation();

        if (form.checkValidity() === true) {
            handleRegistration();           
        } 
        setValidated(true);        
    };

    const handleRegistration = async () => {
        console.log("Starting Registration Call...");                   
             
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
                
                setShowRegistration(false);
                setShowConfirmation(true);
            }              
            console.log('Done!');   
        });             
    };


    //data.data.errors[0].code.replaceAll('.', ' ')

    return (
        <>
            <Modal  
                show={showRegistration} 
                onHide={handleCloseRegistration} 
                centered
                size='lg'
                fullscreen='false'
                animation
            >                
                <Modal.Header closeButton>
                    <Modal.Title>Register New Account:</Modal.Title>
                </Modal.Header>
                <Form noValidate validated={validated} onSubmit={handleSubmit}>
                    <Modal.Body>  
                            <Container fluid> 
                                <Row>  
                                    <Col md="6">
                                        <Form.Group className="mb-3" controlId="formFistName">
                                            <Form.Label>First Name</Form.Label>
                                            <InputGroup hasValidation>
                                                <Form.Control 
                                                    type="text" 
                                                    placeholder="Enter First Name" 
                                                    value={firstName} 
                                                    onChange={ (event) => setFirstName(event.target.value) }
                                                    required
                                                /> 
                                                <Form.Control.Feedback type="invalid">
                                                    Please enter your first name.
                                                </Form.Control.Feedback>
                                            </InputGroup>                                                           
                                        </Form.Group>
                                    </Col>
                                    <Col md="6">
                                        <Form.Group className="mb-3" controlId="formLastName">
                                            <Form.Label>Last Name</Form.Label>
                                            <InputGroup hasValidation>
                                                <Form.Control 
                                                    type="text" 
                                                    placeholder="Enter Last Name" 
                                                    value={lastName} 
                                                    onChange={ (event) => setLastName(event.target.value) }
                                                    required
                                                />  
                                                <Form.Control.Feedback type="invalid">
                                                    Please enter your last name.
                                                </Form.Control.Feedback>
                                            </InputGroup>                                                           
                                        </Form.Group>   
                                    </Col>                             
                                </Row>

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
                                                Please choose an username (email).
                                            </Form.Control.Feedback>
                                        </InputGroup>                                                           
                                    </Form.Group>
                                </Col> 
                                </Row>  
                            
                                <Row>
                                    <Col md="6">
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
                                                        Please, enter a password (8 to 128 characters long)
                                                </Form.Control.Feedback>
                                            </InputGroup>
                                        </Form.Group>                                         
                                    </Col>

                                    <Col md="6">
                                        <Form.Group className="mb-3" controlId="formVerifyPassword">                                  
                                            <Form.Label>Confirm Password</Form.Label>
                                            <InputGroup hasValidation>                                                
                                                <Form.Control 
                                                    type="password" 
                                                    placeholder="Re-type Password" 
                                                    value={verifyPassword} 
                                                    onChange={ (event) => setVerifyPassword(event.target.value) }
                                                    required
                                                />
                                                <Form.Control.Feedback type="invalid">
                                                    Please, make sure this field matches the password.
                                                </Form.Control.Feedback>
                                            </InputGroup>

                                        </Form.Group> 
                                    </Col>
                                </Row>
                                <Row>
                                    <Form.Group className="mb-3">
                                        <Form.Check
                                            required
                                            label="Agree to terms and conditions"
                                            feedback="You must agree before submitting."
                                            feedbackType="invalid"
                                        />
                                    </Form.Group>
                                </Row>
                                <Row>
                                    { hasError &&                                 
                                        <Col>
                                            <Alert variant="danger" onClose={() => setHasError(false)} dismissible>
                                                <Alert.Heading>
                                                    {
                                                        axiosResponseData !== null && axiosResponseData.data !== null &&
                                                        <>{axiosResponseData.message || 'Unknown Error.'}</>
                                                    }
                                                </Alert.Heading>
                                                <p>
                                                    <span><b>{axiosResponseData.data.exception}:</b></span><br/>
                                                    {
                                                        axiosResponseData !== null && axiosResponseData.data !== null && axiosResponseData.data.errors !== null &&
                                                        axiosResponseData.data.errors.map((error: any) => { 
                                                            const message = error.defaultMessage.replaceAll('.', ' ');
                                                            return <><span key={ Math.random() * 10 }><b>{ capitalizeFirstCharacter(error.field) }:</b> { ' ' + capitalizeFirstCharacter(message) }</span><br/></>;
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
                        <Button variant="secondary" onClick={handleCloseRegistration} size="sm">
                            Cancel
                        </Button>

                        <Button variant="primary" type="submit" size="sm">
                            Register
                        </Button>
                    </Modal.Footer>  
                </Form>              
            </Modal>


            <Modal  
                show={showConfirmation} 
                onHide={handleCloseConfirmation} 
                centered
                size='lg'
                fullscreen='false'
                animation
            >                
                <Modal.Header closeButton>
                    <Modal.Title>Confirmation Required:</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <h3>{axiosResponseData.message}</h3>
                    <p>
                        <b>Congratulatios, {capitalizeFirstCharacter(axiosResponseData.data.request.firstName)}!</b> Your brand new FoodApp account is waiting for you.
                        In short you will receive an email from us at ({axiosResponseData.data.request.email}) with a link that will allow you to confirm your email. Please click on that link to activate your account.
                    </p>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="primary" type="submit" onClick={handleCloseConfirmation} size="sm">
                        OK
                    </Button>
                </Modal.Footer>
            </Modal>
        </>
    );
}

export default RegistrationForm;