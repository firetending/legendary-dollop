import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.scss';
import App from './App';
import reportWebVitals from './reportWebVitals';
import ThemeProvider from 'react-bootstrap/ThemeProvider';
import {  BrowserRouter } from 'react-router-dom';

// import { BrowserRouter } from 'react-router-dom';

// ReactDOM.render(
//   <BrowserRouter>
//     <App />
//   </BrowserRouter>,
//   document.getElementById('root')
// );





// const root = ReactDOM.createRoot( document.getElementById('root') as HTMLElement );
// root.render(
//   <React.StrictMode>
//     <ThemeProvider
//       breakpoints={['xxxl', 'xxl', 'xl', 'lg', 'md', 'sm', 'xs', 'xxs']}
//       minBreakpoint="xxs"
//     >
//     <App />
//     </ThemeProvider>
//   </React.StrictMode>
// );

const root = ReactDOM.createRoot( document.getElementById('root') as HTMLElement );
root.render(
  <BrowserRouter>
    <ThemeProvider
      breakpoints={['xxxl', 'xxl', 'xl', 'lg', 'md', 'sm', 'xs', 'xxs']}
      minBreakpoint="xxs"
    >
    <App />
    </ThemeProvider>
  </BrowserRouter>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
