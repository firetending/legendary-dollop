
import { BrowserRouter, Router, Routes, Route, Navigate } from 'react-router-dom';
import React from 'react';
import { useState } from 'react';
import HomePage from "./pages/home-page/HomePage";
import MainView from "./pages/main-view/MainView";
import About from "./pages/about/About";
import NoPage404 from "./pages/no-page/NoPage404";

import NavegationBar from './components/navbar/NavegationBar';

import './App.scss';


function App() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={ <Navigate to="/home" /> } /> 
                                       
        <Route path="home" element={<HomePage />} /> 
        <Route path="main" element={<MainView />} /> 
        <Route path="about" element={<About />} />          
        <Route path="*" element={<NoPage404 />} />
        
      </Routes>
    </BrowserRouter>
  );
}

export default App
