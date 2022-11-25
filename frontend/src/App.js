// import {Routes, Route} from 'react-router-dom'
import React from "react";
import Navbar from './components/Navbar';
import Hero from "./components/Hero";


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
  return (
    <>
    <Navbar />
    <Hero />
    </>
  );
}

export default App
