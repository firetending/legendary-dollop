//import React from "react";
import { useState, useEffect, useContext } from "react"
import { Container, Row, Col } from "react-bootstrap";
import { FaDatabase, FaAsterisk, FaGoogle, FaFacebook, FaUniversity, FaHospital } from "react-icons/fa";
import { useSearchParams,  useNavigate } from 'react-router-dom';
import { GlobalContext } from '../../context/GlobalState';
import doAxiosFetch from '../../utils/doAxiosFetch';
import './Confirmation.scss';


const Confirmation = () => {
    const timerInitialValue = 15;
    const { resetLoginData, globalAppData } = useContext<any>(GlobalContext);
    const [queryParameters] = useSearchParams();
    const [token, setToken] = useState<any>(null);
    const [counter, setCounter] = useState<number>(timerInitialValue);
    const [axiosResponseData, setAxiosResponseData] = useState<any>(null);
    let navigate = useNavigate(); 
    
    const confirmUser = (): void => {
      console.log('Starting Confirmation...');
      setToken(queryParameters.get("confirmation-token"));      
       
  
      doAxiosFetch({
        method: "GET",
        url: "http://localhost:8081/api/v1/registration/confirm?confirmation-token=" + token, 
        headers: {  }  
  
      }).then((result: any) => { 
        console.log('Result: ' + JSON.stringify(result));
        const data = result.data;
        setAxiosResponseData(data);
        console.log('Data: ' + axiosResponseData);


        resetLoginData();
      });
    };

    useEffect(() => {      
      
      const timer: any = counter > -2 && setInterval(() => setCounter(counter - 1), 1000);

      return () => { 
        clearInterval(timer);
        console.log('Counter: ' + counter);
        if(counter <= 0){   
               
          navigate("/home");
        }     
      };
    }, [counter]);
   
      
    return (
        <Container fluid>
          <Row className="confirmation-section">
            <Col>
              <h2>Account Confirmation was successful</h2>
              <p>
                <b>
                  Congratulations! Your account has been confirmed using Access Token: {token}
                </b>
                <br/>
                You will be redirected in {counter} seconds
              </p>
            </Col>
          </Row>
        </Container>  
    );
};

export default Confirmation;