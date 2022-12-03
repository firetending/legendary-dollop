// import {Routes, Route} from 'react-router-dom'
import React from "react";
import { useState } from "react"
import NavegationBar from '../../components/navbar/NavegationBar';
import Hero from "../../components/hero/Hero";
import Overview from "../../components/overview/Overview";
import Footer from "../../components/footer/Footer";
import ThemeProvider from 'react-bootstrap/ThemeProvider';

const MainView = () => {

  return (
    <>           
      <NavegationBar/>
        <h1>Hello World!</h1>
      <Footer/>
    </>
  );
}

export default MainView;
