
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import React from 'react';
import { useState } from 'react';
import HomePage from "./pages/home-page/HomePage";
import MainView from "./pages/main-view/MainView";

import './App.scss';


function App() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/"  element={<HomePage />}> {/*{ <Navigate to="/home" /> }*/ }
          
          <Route path="home" element={<HomePage />} />
          {/* 
          <Route path="blogs" element={<About />} />
          <Route path="contact" element={<Contact />} /> 
          <Route path="*" element={<NoPage />} />          
          */}
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App
