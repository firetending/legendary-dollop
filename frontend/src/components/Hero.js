import React from "react";
import { FaDatabase, FaAsterisk, FaGoogle, FaFacebook, FaUniversity, FaHospital } from "react-icons/fa";
import './Hero.css'


const Hero = () => {
    return (
        <div className='hero'>
            <div className='container'>
                <div className='content'>
                    <div className="col-1">
                        <h1>Food App</h1>
                        <h1><span className='primary-color'>The Perfect Meal Planner</span></h1>
                        <p>An all-encompassing food service system that helps to streamline 
                            an organizations food service and hospitality needs.</p>
                   
                    <div className='used-by'>
                        <p>USED BY</p>
                        <div className='icons'>
                            <span><FaDatabase />LaunchCode</span>
                            <span><FaUniversity />Universities</span>
                            <span><FaHospital />Health Care Organizations</span>
                        </div>
                    </div>
                    </div>
                    <div className='col-2'>
                        <div className='form-layout'>
                            <div className='form-container'>
                                <p className='sign-in-txt'>Sign in with</p>
                                <div className='social-login'>
                                    <span><FaFacebook size={20} /></span>
                                    <span><FaGoogle size={20} /></span>
                                    <span><FaUniversity size={20} /></span>
                                </div>
                                <div className='divider'>
                                    <p><span>Or</span></p>
                                </div>
                                <form action=''>
                                    <input type='email' placeholder='Email' />
                                    <input type='password' placeholder='Password' />
                                    <p>Forgot Password?</p>
                                    <button>Sign In</button>
                                </form>
                            </div>
                            <div className='form-footer'>
                                <p>
                                    Somethings that we might want it to say.
                                    <span className='primary-color'>Terms and Conditions</span>
                                    and <span className='primary-color'>Cookies Policy</span>.
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Hero