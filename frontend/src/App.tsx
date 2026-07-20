import './App.css'
import {Route,Routes, BrowserRouter as Router} from 'react-router-dom';
import Landingpage from './pages/Landingpage';
import Authentication from './pages/Authentication/Authentication';
import Login from './pages/Authentication/login';

function App() {

  return (
    <>
      <Router>
            <Routes>
              <Route path='/' element={<Landingpage></Landingpage>}/>
              <Route path='/auth' element={<Authentication></Authentication>}/>
              <Route path='/login'element={<Login></Login>}/>
            </Routes>
      </Router>
    </>
  )
}

export default App;
