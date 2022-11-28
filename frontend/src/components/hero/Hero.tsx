import React from "react";
import { Container, Row, Col } from "react-bootstrap";
import { FaDatabase, FaAsterisk, FaGoogle, FaFacebook, FaUniversity, FaHospital } from "react-icons/fa";
import LoginForm from '../login-form/LoginForm';
import './Hero.scss';


const Hero = () => {
    return (
        <Container fluid className="hero">  
            <Row className="hero-offset">
                <div></div>
            </Row>          
            <Row className="hero-header">
                <Col>                
                    <h1>FoodApp</h1>
                    <Container fluid className="hero-card">
                        <h2><span>The Perfect Meal Planner</span></h2>
                        <Container className="hero-text">
                            <p>
                                An all-encompassing food service system that helps to streamline 
                                an organizations food service and hospitality needs.
                            </p>
                        </Container>
                        
                    </Container>
                </Col>
                
            </Row>

            <Row className="hero-description overlay">
                <Col>
                    <h2>Some cool content here</h2>
                    <p>
                        Lorem ipsum... you get the idea.
                    </p>
                </Col>
            </Row>
        </Container>




        // <div className='hero'>
        //     <div className='container'>
        //         <div className='content'>
        //             <div className="col-12">
        //                 <h1>Food App</h1>
        //                 <h1><span className='primary-color'>The Perfect Meal Planner</span></h1>
        //                 <p>
        //                     An all-encompassing food service system that helps to streamline 
        //                     an organizations food service and hospitality needs.
        //                 </p>
                   
        //                 <div className='used-by'>
        //                     <p>USED BY</p>
        //                     <div className='icons'>
        //                         <span><FaDatabase />LaunchCode</span>
        //                         <span><FaUniversity />Universities</span>
        //                         <span><FaHospital />Health Care Organizations</span>
        //                     </div>
        //                 </div>

        //                 <LoginForm showLogin={ showLogin } setShowLogin={ setShowLogin }/>

        //             </div>  
        //         </div>
        //     </div>
        // </div>
    );
}

export default Hero;