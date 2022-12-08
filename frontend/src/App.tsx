// import {Routes, Route} from 'react-router-dom'
import React from "react";
import { useState } from "react"
import NavegationBar from './components/navbar/NavegationBar';
import Hero from "./components/hero/Hero";
import Overview from "./components/overview/Overview";
import Footer from "./components/footer/Footer";
import ThemeProvider from 'react-bootstrap/ThemeProvider';
import { BrowserRouter as Router ,Routes, Route } from 'react-router-dom';
import UserDashboard from './components/user-dashboard/UserDashboard'

import './App.scss';

function App() {

  return (
    <>
      <Router>
      <Routes>
      {/* <ThemeProvider
        breakpoints={['xxxl', 'xxl', 'xl', 'lg', 'md', 'sm', 'xs', 'xxs']}
        minBreakpoint="xxs"
      > */}
      <Route path='/' element={<NavegationBar />}>
      <Route index element={<Hero />} />
      <Route index element={<Overview />} />
      <Route path="dashboard" element={<UserDashboard />} />
        
        {/* <NavegationBar/>
        <Hero/>
        <Overview />
        <Footer/> */}
      </Route>
      {/* </ThemeProvider> */}
      </Routes>
      </Router>
    </>
  );
}

export default App
