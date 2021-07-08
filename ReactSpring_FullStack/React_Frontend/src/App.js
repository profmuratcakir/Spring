import React from "react";
import Header from "./components/Header";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Kayit from "./components/Kayit";
function App() {
  return (
    <Router>
      <Header />
      <Switch>
        <Route exact path="/">
          {/* <Listele /> */}
        </Route>
        <Route path="/ekle">
          <Kayit />
        </Route>
      </Switch>
    </Router>
  );
}

export default App;
