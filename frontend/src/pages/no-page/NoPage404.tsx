// import {Routes, Route} from 'react-router-dom'
import React from "react";
import { useState } from "react"
import NavegationBar from '../../components/navbar/NavegationBar';
import Footer from "../../components/footer/Footer";
import ThemeProvider from 'react-bootstrap/ThemeProvider';
import { Modal, Button, Form, Container, Row, Col, Alert, InputGroup} from 'react-bootstrap';

const NoPage404 = () => {

  return (
    <>
      <ThemeProvider
        breakpoints={['xxxl', 'xxl', 'xl', 'lg', 'md', 'sm', 'xs', 'xxs']}
        minBreakpoint="xxs"
      >        
        <NavegationBar/>
        <Container>
          <Row>
            <h1>Oops! Wrong turn. (404)</h1>
          </Row>
          <Row>
            <h3>This page doesn't exist</h3>
          </Row>
        </Container>          
        <Footer/>
      </ThemeProvider>
    </>
  );
}

export default NoPage404;
