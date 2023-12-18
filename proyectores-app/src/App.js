import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import HomePage from './pages/HomePage';
import ManageProyectores from './pages/ManageProyectores';
import ManagePrestamos from './pages/ManagePrestamos';
import ProfesoresPage from './pages/ProfesoresPage';

function App() {
  return (
      <Router>
        <Switch>
          <Route path="/" exact component={HomePage} />
          <Route path="/proyectores" component={ManageProyectores} />
            <Route path="/profesores" component={ProfesoresPage} />
          <Route path="/prestamos" component={ManagePrestamos} />
          {/* Más rutas según sea necesario */}
        </Switch>
      </Router>
  );
}

export default App;
