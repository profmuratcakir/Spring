import React from "react";
import Header from "./components/Header";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Kayit from "./components/Kayit";
import Listele from "./components/Listele";
import Guncelle from "./components/Guncelle";

function App() {
  return (
    <Router>
      <Header />
      <Switch>
        <Route exact path="/">
          <Listele />
        </Route>
        <Route path="/ekle">
          <Kayit />
        </Route>
        <Route path="/guncelle/:id">
          <Guncelle />
        </Route>
      </Switch>
    </Router>
  );
}

export default App;
