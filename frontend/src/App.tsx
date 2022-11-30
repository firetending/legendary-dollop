import React from 'react';
import { BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import MenuCreationForm from './components/MenuCreationForm';
import {Menulist} from "./components/Menulist";
import {GlobalProvider} from './context/GlobalState';


function App() {
  return (
    <GlobalProvider>
    <Router>

      <Routes>

        <Route path="/menucreationform" element={<MenuCreationForm />} />

        <Route path="/menulist" element={<Menulist />} />

      </Routes>

    </Router> 
    </GlobalProvider> 
  );
}

export default App;