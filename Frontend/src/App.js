
import './App.css';
import {Route,Routes} from 'react-router-dom'
import Dropdown from './Components/Dropdown';
import JobPost from './Components/JobPost';
import NavBar from './Components/NavBar';
import Options from './MockInfo/Options';
import Search from './Components/Search';
import { Post } from './Components/Post';
// import {BrowserRouter as Router,Route,Switch} from 'react-router-dom';
// import { Post } from './Components/Post';
// import './Styles/JobPost.css';

const App = ()=> {
  return (
 
    <div className="App">
         <NavBar/>
       <Routes>
        <Route path="/" element = {<Search/>}/>
        <Route path="/search" element={<JobPost/>}/>
        <Route path="/post" element={<Post/>}></Route>
      </Routes>
    </div>
   
  );
}

export default App;

