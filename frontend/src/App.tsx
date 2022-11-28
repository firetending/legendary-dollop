// import {Routes, Route} from 'react-router-dom'
import React from "react";
import { useState } from "react"
import NavegationBar from './components/navbar/NavegationBar';
import Hero from "./components/hero/Hero";
import Overview from "./components/overview/Overview";
import Footer from "./components/footer/Footer";
import ThemeProvider from 'react-bootstrap/ThemeProvider';

import './App.scss';

// function App() {
//   return (
//     <>
//     <Routes>
//       <Route path='/' element={<Hero />}/>
//     </Routes>
//     </>
//   );
// }

function App() {
  const [showLogin, setShowLogin] = useState(false);
  return (
    <>
      <ThemeProvider
        breakpoints={['xxxl', 'xxl', 'xl', 'lg', 'md', 'sm', 'xs', 'xxs']}
        minBreakpoint="xxs"
      >
        <NavegationBar setShowLogin={setShowLogin}/>
        <Hero showLogin={showLogin} setShowLogin={ setShowLogin }/>
        <Overview />
        <Footer/>
      </ThemeProvider>
    </>
  );
}

export default App
