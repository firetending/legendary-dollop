import React, {useState} from "react";
// import {Link} from 'react-router-dom';
import {FaBars, FaTimes, FaFacebook, FaGoogle, FaUniversity} from 'react-icons/fa';
import './LoginForm.scss';
import { Modal, Button, Form } from 'react-bootstrap';


const LoginForm = ({ showLogin, setShowLogin }: {showLogin: boolean; setShowLogin: any}) => {

    const handleClose = () => { setShowLogin(false) };
    const handleLogin = () => {
        console.log("Starting Login");
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
                <Modal.Body>                                     
                    <Form>                            
                        <Form.Group className="mb-3" controlId="formBasicEmail">
                            <Form.Label>Email address</Form.Label>
                            <Form.Control type="email" placeholder="Enter email" />
                            <Form.Text className="text-muted">
                                We'll never share your email with anyone else.
                            </Form.Text>                            
                        </Form.Group>  

                        <Form.Group className="mb-3" controlId="formPassword">                                  
                            <Form.Label>Password</Form.Label>
                            <Form.Control type="password" placeholder="Password" />                                
                            <Form.Text className="text-muted">
                                <a href="#">Forgot Password?</a>  
                            </Form.Text>
                        </Form.Group>                        
                    </Form>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleClose} size="sm">
                        Cancel
                    </Button>

                    <Button variant="primary" onClick={handleLogin} type="submit" size="sm">
                        Login
                    </Button>
                </Modal.Footer>                
            </Modal>
        </>

        // <div className='col-2'>
        //     {
        //         showLogin === true && <h1>Hi there</h1>
        //     }
        //     <div className='form-layout'>
        //         <div className='form-container'>
        //             <p className='sign-in-txt'>Sign in with</p>
        //             <div className='social-login'>
        //                 <span><FaFacebook size={20} /></span>
        //                 <span><FaGoogle size={20} /></span>
        //                 <span><FaUniversity size={20} /></span>
        //             </div>
        //             <div className='divider'>
        //                 <p><span>Or</span></p>
        //             </div>
        //             <form action=''>
        //                 <input type='email' placeholder='Email' />
        //                 <input type='password' placeholder='Password' />
        //                 <p>Forgot Password?</p>
        //                 <button>Sign In</button>
        //             </form>
        //         </div>
        //         <div className='form-footer'>
        //             <p>
        //                 Somethings that we might want it to say.
        //                 <span className='primary-color'>Terms and Conditions</span>
        //                 and <span className='primary-color'>Cookies Policy</span>.
        //             </p>
        //         </div>
        //     </div>
        // </div>
    );
}

export default LoginForm;