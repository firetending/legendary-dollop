import React from "react";
import { Container, Row, Col, Image } from "react-bootstrap";
import { FaDatabase, FaAsterisk, FaGoogle, FaFacebook, FaUniversity, FaHospital } from "react-icons/fa";
import './Overview.scss';


const Overview = () => {
    return (
        <Container fluid className="overview overlay">
            <Container className="team">
                <Row>
                    <h2>The Team</h2>
                </Row>
                <Row>
                    <Col>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                    </Col>                    
                </Row>

                <Row className="justify-content-md-center">
                    <Col>
                        <a href="https://www.linkedin.com/in/chiyantse/" target="_blank" className="avatar">
                            <Image roundedCircle fluid src="https://media-exp1.licdn.com/dms/image/D5635AQGYfCoxyyT-Lg/profile-framedphoto-shrink_400_400/0/1653439559038?e=1670997600&v=beta&t=NeZn6xJfj5xqvLmXjDla3nsvKm_1jq8rDjL_wh2wDpI" alt="" />
                            <h4>Chi Tse</h4>
                        </a>
                    </Col>
                </Row>
                <Row className="justify-content-md-center">                    
                    <Col>
                        <a href="https://www.linkedin.com/in/alan-miller-9162b220/" target="_blank" className="avatar">
                            <Image roundedCircle fluid src="https://media-exp1.licdn.com/dms/image/C4E03AQHV5Xfgh-SZIA/profile-displayphoto-shrink_400_400/0/1649950878269?e=1675900800&v=beta&t=yXCACs5uxd7dzTypABt6Alnx0EFqMLxeQSdQPcmnk6Y" alt="" />
                            <h4>Alan Miller</h4>
                        </a>
                    </Col>
                    <Col>
                        <a href="https://www.linkedin.com/in/chromadesk/" target="_blank" className="avatar">
                            <Image roundedCircle fluid src="data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7" alt="" />
                            <h4>Eliyah Yisrael</h4>
                        </a>
                    </Col>
                </Row>
                <Row className="justify-content-md-center">
                    <Col>
                        <h2 className="app-name">FoodApp</h2>
                    </Col>
                </Row>
                <Row className="justify-content-md-center">                    
                    <Col>
                        <a href="https://www.linkedin.com/in/alanna-woods-162221230/" target="_blank" className="avatar">
                            <Image roundedCircle fluid src="https://media-exp1.licdn.com/dms/image/D4E35AQFb47kuvJAH_w/profile-framedphoto-shrink_400_400/0/1669754240089?e=1670997600&v=beta&t=NYJXchzpkFb4gC08Q6yT3dOt6lMb-S0HrSKxYhVI4no" alt="" />
                            <h4>Alanna Woods</h4>
                        </a>                        
                    </Col>
                    <Col>
                        <a href="https://www.linkedin.com/in/nyemah-wisseh-69547a133/" target="_blank" className="avatar">
                            <Image roundedCircle fluid src="data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7" alt="" />
                            <h4>Nyemah Wisseh</h4>
                        </a>
                    </Col>                                        
                </Row>
                <Row>
                    <Col className="justify-content-md-center">
                        <a href="https://www.linkedin.com/in/victor-diaz-2366b598/" target="_blank" className="avatar">
                            <Image roundedCircle fluid src="https://media-exp1.licdn.com/dms/image/C4D03AQGHWSz9Fiz8nA/profile-displayphoto-shrink_400_400/0/1647913379111?e=1675900800&v=beta&t=GWEGYEb6JuDDC0sbGE22oH39kp6QRRSU1ZGd7GUAKCQ" alt="" />
                            <h4>Victor Diaz</h4>
                        </a>
                    </Col>  
                </Row>
            </Container>
            <Container  className="recomendations">              
                <Row className="justify-content-md-center">
                    <Col>
                        <div className='used-by'>
                            <p>USED BY</p>                        
                        </div>
                    </Col>
                </Row>
                <Row className="justify-content-md-center">
                    <div className='icons'>
                        <Col><FaDatabase/><span>LaunchCode</span></Col>
                        <Col><FaUniversity/><span>Universities</span></Col>
                        <Col><FaHospital/><span>Health Care</span></Col>
                    </div>
                </Row>
            </Container>
        </Container>
    );
};

export default Overview;