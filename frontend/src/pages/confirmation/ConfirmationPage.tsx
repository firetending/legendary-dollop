// import {Routes, Route} from 'react-router-dom'
import React from "react";
import { useState, useEffect } from "react"
import NavegationBar from '../../components/navbar/NavegationBar';
import Footer from "../../components/footer/Footer";
import Confirmation from "../../components/confirmation/Confirmation";
import ThemeProvider from 'react-bootstrap/ThemeProvider';
import { Modal, Button, Form, Container, Row, Col, Alert, InputGroup} from 'react-bootstrap';
import { useSearchParams } from 'react-router-dom';
import doAxiosFetch from '../../utils/doAxiosFetch';

const ConfirmationPage = () => {




  return (
    <>        
        <NavegationBar/>
        <Confirmation />     
        <Footer/>   
    </>
  );
}

export default ConfirmationPage;
