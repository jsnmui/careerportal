import React from "react";

//react routing
import { ReactDOM } from "react";
// import { Route, Switch } from "react-router-dom";

//components
import Dropdown from './Components/Dropdown';
import JobPost from './Components/JobPost';
import NavBar from './Components/NavBar';
import { Post } from './Components/Post';
import Options from './MockInfo/Options';

import './App.css';
import { Component } from "react";
// import './Styles/JobPost.css';

const App = () => {
  return (
        <div className="App">
            
            <JobPost/>
            <Post/>
            <Dropdown placeHolder="Location" options ={Options}/>
        </div>
      );
  
};


export default App;
// function App() {
//  
// }

// return (
//   <div>
//     <NavBar/>
//     <Switch>
// <route path "/" exact Component = {}>
//       <Route path="/jobs" exact component={JobPost}/>
//       </Switch>
   
//       </div>
// );