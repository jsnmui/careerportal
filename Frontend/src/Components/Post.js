import React from 'react'
import {JobPostInfo} from '../MockInfo/JobPostInfo'

export const Post = () => {
  return (
    <>
        <div>
            {JobPostInfo.map((item, index)=>{
                return(
                    <>
                        <div key={index}>
                            <h1>{item.job}</h1>
                            <h4>{item.department}</h4>
                            <h4>{item.location}</h4>
                            {item.salaryIcon}{item.salary}
                            <p>{item.description}</p>
                        </div>
                    
                    </>
                )
            })}
        </div>
    
    </>
  )
}
