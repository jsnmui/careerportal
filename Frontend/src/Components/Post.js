import React,{useEffect, useState} from 'react'
import axios from 'axios'
// import {JobPostInfo} from '../MockInfo/JobPostInfo'
import '../Styles/post.css'

export const Post = () => {   
    const [repo,setRepo] = useState([])
    const baseURL = "http://localhost:8080/jobs";

    const getPosts = () => {
        axios.get(baseURL)
    .then((response)=>{
        console.log(response)
        const myRepo = response.data;
        setRepo(myRepo);

    })
}
useEffect(()=> getPosts(), [])
    

            

    
  return (
    <>
    {repo.map((item,index)=>{
        return(
       <div key={index}>
            <h2>{item.jobTitle}</h2>
            <p>{item.jobDescription}</p>
            <div>{item.minSal} - {item.maxSal}</div>
            <p>{item.postDate}</p>
            <p>{item.postingEndDate}</p>
            <p>{String(item.isActive)}</p>
       </div>

        )
       
    })}
   
        
 
    
    </>
  )
}




{/* <div>
 


{JobPostInfo.map((item, index)=>{
    return(
        <>
            <div key={index} className={item.cName}>
                <h3 id='header'>{item.job}</h3>
                <h4 className='departmenttxt'>{item.department}</h4>
                <h4 className='locationtxt'>{item.location}</h4>
               <div className='salarytxt'> {item.salaryIcon}{item.salary}</div>
                <p className=''>{item.description}</p>
                <h5 className=''>Date Posted: {item.date}</h5>
            </div>
        
        </>
    )
})}
</div> */}