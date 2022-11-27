import React from "react";
import { FaDatabase, FaAsterisk, FaGoogle, FaFacebook, FaUniversity, FaHospital } from "react-icons/fa";
import LoginForm from '../loginform/LoginForm';
import './Hero.scss';


const Hero = ({ showLogin, setShowLogin }: { showLogin: boolean; setShowLogin: any }) => {
    return (
        <div className='hero'>
            <div className='container'>
                <div className='content'>
                    <div className="col-1">
                        <h1>Food App</h1>
                        <h1><span className='primary-color'>The Perfect Meal Planner</span></h1>
                        <p>
                            An all-encompassing food service system that helps to streamline 
                            an organizations food service and hospitality needs.
                        </p>
                   
                        <div className='used-by'>
                            <p>USED BY</p>
                            <div className='icons'>
                                <span><FaDatabase />LaunchCode</span>
                                <span><FaUniversity />Universities</span>
                                <span><FaHospital />Health Care Organizations</span>
                            </div>
                        </div>

                        <LoginForm showLogin={ showLogin } setShowLogin={ setShowLogin }/>

                    </div>  
                </div>
            </div>
        </div>
    );
}

export default Hero;