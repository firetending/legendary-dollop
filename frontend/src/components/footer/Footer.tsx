import React from "react";
import { Container, Row, Col } from "react-bootstrap";
import { FaDatabase, FaAsterisk, FaGoogle, FaFacebook, FaUniversity, FaHospital } from "react-icons/fa";
import './Footer.scss';


const Footer = () => {
    return (
        <Container fluid className="footer">              
            <Row>
                <Col>
                    <div>Copyright 2022</div>
                </Col>
            </Row>
        </Container>
    );
};

export default Footer;