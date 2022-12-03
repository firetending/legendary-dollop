
import { BrowserRouter, Router, Routes, Route, Navigate } from 'react-router-dom';
import React from 'react';
import { useState } from 'react';
import ThemeProvider from 'react-bootstrap/ThemeProvider';
import HomePage from "./pages/home-page/HomePage";
import MainView from "./pages/main-view/MainView";
import About from "./pages/about/About";
import ConfirmationPage from "./pages/confirmation/ConfirmationPage";
import NoPage404 from "./pages/no-page/NoPage404";

import NavegationBar from './components/navbar/NavegationBar';

import './App.scss';


function App() {

  return (
    <>
      <ThemeProvider
          breakpoints={['xxxl', 'xxl', 'xl', 'lg', 'md', 'sm', 'xs', 'xxs']}
          minBreakpoint="xxs"
      > 
        <BrowserRouter>
          <Routes>
            <Route path="/" element={ <Navigate to="/home" /> } /> 
                                          
            <Route path="home" element={<HomePage />} /> 
            <Route path="main" element={<MainView />} /> 
            <Route path="about" element={<About />} />  
            <Route path="confirmation" element={<ConfirmationPage />} />        
            <Route path="*" element={<NoPage404 />} />
            
          </Routes>
        </BrowserRouter>
      </ThemeProvider>
    </>
  );
}

export default App
