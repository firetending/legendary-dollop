// import {Routes, Route} from 'react-router-dom'
import React from "react";
import { useState, useEffect } from "react"
import NavegationBar from '../../components/navbar/NavegationBar';
import Footer from "../../components/footer/Footer";
import ThemeProvider from 'react-bootstrap/ThemeProvider';
import { Modal, Button, Form, Container, Row, Col, Alert, InputGroup} from 'react-bootstrap';
import { useSearchParams } from 'react-router-dom';
import doAxiosFetch from '../../utils/doAxiosFetch';

const ConfirmationPage = () => {
  const [queryParameters] = useSearchParams();
  const [token, setToken] = useState<any>(null);
  const [axiosResponseData, setAxiosResponseData] = useState<any>(null);
  
  const confirmUser = (): void => {
    console.log('Starting Confirmation...');    

    const accessToken = queryParameters.get("confirmation-token");
    console.log('Confirmation token: ' + accessToken);
    setToken(accessToken); 

    doAxiosFetch({
      method: "GET",
      url: "http://localhost:8081/api/v1/registration/confirm?confirmation-token=" + accessToken, 
      headers: {  }  

    }).then((result: any) => { 
      console.log('Result: ' + JSON.stringify(result));
      const data = result.data;
      setAxiosResponseData(data);
    });
  };

  useEffect(() => {
    confirmUser();
  }, []);
  

  return (
    <>        
        <NavegationBar/>
        <Container>
          <h1>Account Confirmation was successful.</h1>
          <h3>Congratulations! Your account has been confirmed using Access Token: {token}</h3>
        </Container>          
        <Footer/>   
    </>
  );
}

export default ConfirmationPage;
