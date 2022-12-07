
import './App.css';
import Dropdown from './Components/Dropdown';
import JobPost from './Components/JobPost';
import NavBar from './Components/NavBar';
import { Post } from './Components/Post';
import Options from './MockInfo/Options';
// import './Styles/JobPost.css';

function App() {
  return (
    <div className="App">
        <NavBar/>
        <JobPost/>
        <Post/>
        {/* <Dropdown placeHolder="Location" options ={Options}/> */}
    </div>
  );
}

export default App;
