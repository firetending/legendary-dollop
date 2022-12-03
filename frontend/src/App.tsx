
import { BrowserRouter, Router, Routes, Route, Navigate } from 'react-router-dom';

import { useState } from 'react';
import ThemeProvider from 'react-bootstrap/ThemeProvider';
import HomePage from "./pages/home-page/HomePage";
import MainView from "./pages/main-view/MainView";
import About from "./pages/about/About";
import ConfirmationPage from "./pages/confirmation/ConfirmationPage";
import NoPage404 from "./pages/no-page/NoPage404";

import NavegationBar from './components/navbar/NavegationBar';

        import MenuCreationForm from './components/MenuCreationForm';
        import {Menulist} from "./components/Menulist";
        import {GlobalProvider} from './context/GlobalState';

import './App.scss';

        function App() {

        return (
                <>
                  <ThemeProvider
                          breakpoints={['xxxl', 'xxl', 'xl', 'lg', 'md', 'sm', 'xs', 'xxs']}
                  minBreakpoint="xxs"
                  >
                  <GlobalProvider>
                  <BrowserRouter>
                    <Routes>
                      <Route path="/" element={ <Navigate to="/home" /> } />

                      <Route path="home" element={<HomePage />} />
                      <Route path="main" element={<MainView />} />
                      <Route path="about" element={<About />} />
                      <Route path="confirmation" element={<ConfirmationPage />} />
                      <Route path="*" element={<NoPage404 />} />

                      <Route path="/menucreationform" element={<MenuCreationForm />} />
                      <Route path="/menulist" element={<Menulist />} />

                    </Routes>
                  </BrowserRouter>
                  </GlobalProvider>
                </ThemeProvider>
               </>
       );
}

export default App

