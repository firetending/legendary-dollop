// import {Routes, Route} from 'react-router-dom'
import React from "react";
import { useState } from "react"
import NavegationBar from '../../components/navbar/NavegationBar';
import Footer from "../../components/footer/Footer";
import ThemeProvider from 'react-bootstrap/ThemeProvider';
import { Modal, Button, Form, Container, Row, Col, Alert, InputGroup} from 'react-bootstrap';

const About = () => {

  return (
    <>           
      <NavegationBar/>
      <Container>
        <h1>ABOUT</h1>
      </Container>          
      <Footer/>      
    </>
  );
}

export default About;
