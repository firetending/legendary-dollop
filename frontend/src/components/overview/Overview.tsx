import React from "react";
import { Container, Row, Col } from "react-bootstrap";
import { FaDatabase, FaAsterisk, FaGoogle, FaFacebook, FaUniversity, FaHospital } from "react-icons/fa";
import './Overview.scss';


const Overview = () => {
    return (
        <Container fluid className="overview overlay">              
            <Row className="overview">
                <Col>
                    <div className='used-by'>
                        <p>USED BY</p>
                        <div className='icons'>
                            <span><FaDatabase />LaunchCode</span>
                            <span><FaUniversity />Universities</span>
                            <span><FaHospital />Health Care Organizations</span>
                        </div>
                    </div>
                </Col>
            </Row>
        </Container>
    );
};

export default Overview;