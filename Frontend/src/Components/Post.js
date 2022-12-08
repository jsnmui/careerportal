import React from 'react'
import {JobPostInfo} from '../MockInfo/JobPostInfo'
import '../Styles/post.css'

export const Post = () => {
  return (
    <>
        <div>
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
        </div>
    
    </>
  )
}
