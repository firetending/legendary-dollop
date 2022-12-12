import React from 'react';
import { Container, Row, Col, Image, Card } from 'react-bootstrap';
import Logo from '../../images/Adam.png'
import './UserProfile.scss';

const UserProfile = () => {
    return (
        <Container className='user-profile'>
           <Row>
            <Col>
                <Image src={Logo}
                fluid
                rounded
                
                />

            </Col>
            <Col>
                <Container fluid className="name-card my-4">
                        <h1><span>Adam Steiger</span></h1>
                        <p>Member Since: November 5, 2022</p>
                        <Container className="hero-text">
                        </Container>
                        
                    </Container>
                    <Container fluid className="name-card my-4">
                        <h1><span>Contact</span></h1>
                        <Container className="hero-text">
                            <p>
                                Email: adam@launchcode.com
                            </p>
                            <p>
                                Phone: 555-555-5555
                            </p>
                    
                        </Container>
                        
                    </Container>
                    <Container fluid className="name-card my-4">
                        <h1><span>Diet</span></h1>
                        <Container className="hero-text">
                            <p>
                                Vegan
                            </p>
                        </Container>
                        
                    </Container>
            </Col>
            
           </Row>
        </Container>
    )
}

export default UserProfile