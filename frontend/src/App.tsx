import './App.css'
import {Route,Routes, BrowserRouter as Router} from 'react-router-dom';
import Landingpage from './pages/Landingpage';
import Authentication from './pages/Authentication/Authentication';

function App() {

  return (
    <>
      <Router>
          <Routes>
              <Route path='/' element={<Landingpage></Landingpage>}/>
              <Route path='/auth' element={<Authentication></Authentication>}/>
          </Routes>
      </Router>
    </>
  )
}

export default App;
