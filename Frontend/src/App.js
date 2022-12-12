
import './App.css';
import Dropdown from './Components/Dropdown';
import JobPost from './Components/JobPost';
import NavBar from './Components/NavBar';
import Options from './MockInfo/Options';
import Search from './Components/Search';
import {BrowserRouter as Router,Route,Switch} from 'react-router-dom';
// import './Styles/JobPost.css';

function App() {
  return (
    <Router>
    <div className="App">
        <NavBar/>
          <Switch>

              <Route path = '/Search'>
                <Search/>
              </Route>

              <Route path = '/'>
                <JobPost/>
                <Dropdown placeHolder="Location" options ={Options}/>
            </Route>

          </Switch>
    </div>
    </Router>
  );
}

export default App;