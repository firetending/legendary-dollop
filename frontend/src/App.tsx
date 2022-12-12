// import {Routes, Route} from 'react-router-dom'
//import React from "react";
import React, { Component } from "react";
import { useState } from "react"
import NavegationBar from './components/navbar/NavegationBar';
import Hero from "./components/hero/Hero";
import Overview from "./components/overview/Overview";
import Footer from "./components/footer/Footer";
import ThemeProvider from 'react-bootstrap/ThemeProvider';
// import { BrowserRouter as Router ,Routes, Route } from 'react-router-dom';
import {Routes, Route } from 'react-router-dom';
import UserDashboard from './components/user-dashboard/UserDashboard';
import UserProfile from "./components/user-profile/UserProfile";
import Pastmeals from "./components/past-meals/Pastmeals";
import FuturemealTable from "./components/future-meals/FuturemealTable";
import NoPage from "./components/NoPage";

import './App.scss';

// function App() {
class App extends Component {
    state = {
        characters: [
            {   
                date: 'November 25, 2022',
                name: 'Breakfast',
                job: 'Pancake Platter, Orange Juice, Milk',
              },
              {
                date: 'November 25, 2022',
                name: 'Lunch',
                job: 'Chicken Ceasar Salad, Water',
              },
              {
                date: 'November 25, 2022',
                name: 'Dinner',
                job: 'Spaghetti and Meatballs, Wine',
              },
              {
                date: 'November 26, 2022',
                name: 'Breakfast',
                job: 'Shrimp and Grits',
              },
        ],
        
    }
  
    removeCharacter = (index: number) => {
        const { characters } = this.state
      
        this.setState({
          characters: characters.filter((character, i) => {
            return i !== index
          }),
        })
      }
  
      render() {
        const { characters } = this.state



  return (
    <>
      {/* <Router> */}
      {/* <ThemeProvider
        breakpoints={['xxxl', 'xxl', 'xl', 'lg', 'md', 'sm', 'xs', 'xxs']}
        minBreakpoint="xxs"
      > */}
      <Routes>
      
      <Route path='/' element={<NavegationBar />}>
      <Route index element={<Hero />} />
      <Route index element={<Overview />} />
      <Route path="dashboard" element={<UserDashboard />}>
      <Route path='futuremeals' element={<FuturemealTable characterData={characters} removeCharacter={this.removeCharacter} />} />
        <Route path='pastmeals' element={<Pastmeals />} />
        <Route path='userprofile' element={<UserProfile />} />
      </Route>
        
        {/* <NavegationBar/>
        <Hero/>
        <Overview />
        <Footer/> */}
      <Route path="*" element={<NoPage />} />
      </Route>
      
      </Routes>
      {/* </ThemeProvider> */}
      {/* </Router> */}
    </>
  );
}
}

export default App
