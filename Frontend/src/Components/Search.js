import React from 'react';
import '../Styles/Search.css';
import {useState} from 'react';
import { Archive } from '../Functions/Archive';

function Search() {
  const [searchTerm, setSearchTerm] = useState('');
  const [searchResults, setSearchResults] = useState([]);
  const [location, setLocation] = useState('');
  const [minSalary, setMinSalary] = useState('');
  const [maxSalary, setMaxSalary] = useState('');
  const [showFilters, setShowFilters] = useState(false);

  function handleSearchInput(event) {
    setSearchTerm(event.target.value);
  }

  function handleSearchSubmit(event) {
    event.preventDefault();

    const dummyData = [
      { id: 1, title: 'Job 1',location : 'New York', minSalary: 50000, maxSalary: 60000},
      { id: 2, title: 'Job 2', location : 'California',minSalary: 40000, maxSalary: 80000 },
      { id: 3, title: 'Job 3', location : 'Florida', minSalary: 60000, maxSalary: 90000 },
    ];

    const filteredData = dummyData.filter(job => {
      if (location && job.location !== location) return false;
      if (minSalary && job.minSalary < minSalary) return false;
      if (maxSalary && job.maxSalary > maxSalary) return false;
      return true;
    });

    setSearchResults(filteredData);
    setShowFilters(true);
  }

  function handleFilterSubmit(event) {
    event.preventDefault();

    const dummyData = [
      { id: 1, title: 'Job 1',location : 'New York', minSalary: 50000, maxSalary: 60000},
      { id: 2, title: 'Job 2', location : 'California',minSalary: 40000, maxSalary: 80000 },
      { id: 3, title: 'Job 3', location : 'Florida', minSalary: 60000, maxSalary: 90000 },
    ];

    const filteredData = dummyData.filter(job => {
            if (location && job.location !== location) return false;
             if (minSalary && job.minSalary < minSalary) return false;
             if (maxSalary && job.maxSalary > maxSalary) return false;
             return true;
           });
        
           setSearchResults(filteredData);
           setShowFilters(true);
         }
         return (
           <div className="search-container">
             <form onSubmit={handleSearchSubmit}>
               <input
                 type="text"
                 value={searchTerm}
                 onChange={handleSearchInput}
                placeholder="Search..."
               />
             </form>
             {showFilters && (
               <form onSubmit={handleFilterSubmit}>
               <div className="filter-container">
                   <input
                     type="text"
                     placeholder="Filter by location"
                         value={location}
                         onChange={e => setLocation(e.target.value)}
                       />
                       <input
                         type="number"
                        placeholder="Minimum salary"
                         value={minSalary}
                        onChange={e => setMinSalary(e.target.value)}
                       />
                       <input
                         type="number"
                         placeholder="Maximum salary"
                         value={maxSalary}
                       onChange={e => setMaxSalary(e.target.value)}
                       />
                       <button type="submit">Filter</button>
                     </div>
                   </form>
                 )}
                 <ul className="search-results">
                   {searchResults.map(result => (
                     <li key={result.id}>
                       <div className="result-title">{result.title}</div>
                       <div className="result-location">{result.location}</div>
                       <div className="result-salary">${result.minSalary} - ${result.maxSalary}</div>
                     </li>
                   ))}
                 </ul>
                 <Archive/>
               </div>
             );
             }
            
             export default Search;