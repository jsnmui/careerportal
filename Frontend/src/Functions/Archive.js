import React, { useState } from "react";
import axios from "axios"

export const Archive = (props) => {
    const [resp,settingRepo] = useState([])
    const baseeURL = "http://localhost:8080/jobs";

    //this is Axios
 const putArchive = (jobId) => {
    axios.put(baseeURL)
 .then((response)=>{
        console.log(response)
        const myResponse = response.data;
        settingRepo(myResponse);
    })
}//i want it to archive the job post and if it works i want isActive to be false in the database
    return (
     <>
     <button id  = 'btn-arc' onClick ="" >Archive</button>
     </>
     ) 
    
    
  
//i need to take JObId from the JobPOst and set it to IsActive from the database from false to IsActive True 
//
//deconstruct Myrepo

function archiveJob(id) {
  fetch(`/api/jobs/archive/${id}`, {method: 'ARCHIVE'})
    .then(response => {
      if (response.ok) {
        // Remove the job from the list of jobs displayed on the page
        const jobs = [...state.jobs];
        const index = jobs.findIndex(job => job.id === id);
        jobs.splice(index, 1);

        // Update the state variable that stores the list of archived jobs
        setState(prevState => ({
          ...prevState,
          jobs: jobs,
          archivedJobs: [...prevState.archivedJobs, id]
        }));
      }
    });
    
    const button = document.getElementById('archive-button');
    button.addEventListener('click', () => {
    const jobId = button.getAttribute('data-job-id');
  archiveJob(jobId);
});

}
}
