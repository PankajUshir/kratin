import './App.css';
import Home from './Components/Home';
import Expenses from './Components/Expenses';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Checkup from './Components/Checkup';

function App() {
  return (
    <BrowserRouter>
    <Routes>
      <Route path="/" element={<Home/>}/>
      <Route path="/expenses" element={<Expenses/>}/>
      <Route path="/checkup" element={<Checkup/>}/>
    </Routes>
  </BrowserRouter>
  );
}

export default App;
