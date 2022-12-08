import React from "react";
import { ReactDOM } from "react";
import './App.css';
// import Dropdown from './Components/Dropdown';
import JobPost from './Components/JobPost';
import NavBar from './Components/NavBar';
// import { Post } from './Components/Post';
// import Options from './MockInfo/Options';

import { Route, Switch } from "react-router-dom";
// import './Styles/JobPost.css';

const App = () => {
  return (
    <div>
      <NavBar/>
      <Switch>
        <Route path="/jobs" exact component={JobPost}/>
        </Switch>
     
        </div>
  );
};


export default App;
// function App() {
//   return (
//     <div className="App">
//         
//         <JobPost/>
//         <Post/>
//         {/* <Dropdown placeHolder="Location" options ={Options}/> */}
//     </div>
//   );
// }