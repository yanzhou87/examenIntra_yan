import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import MonPage from "./comprosants/MonPage";

function App() {
  return (
      <BrowserRouter>
        <Routes>
            <Route path='/' element={<MonPage /> }/>
        </Routes>
      </BrowserRouter>
  );
}

export default App;
