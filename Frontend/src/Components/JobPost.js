import React from "react";
import axios from "axios";
import { useState } from "react";
import '../Styles/JobPost.css'


function JobPost() {

  const [jobId, setJobId] = useState("");
  const [jobTitle, setJobTitle] = useState("");
  const [jobDescription, setJobDescription] = useState("");
  const [departmentId, setDepartmentId] = useState("");
  const [minSal, setMinSal] = useState("");
  const [maxSal, setMaxSal] = useState("");
  const [locationId, setLocationId] = useState("");
  const [userId, setUserId] = useState("");

  async function handleSubmit(event) {
    event.preventDefault();
    try {
      await axios.post("http://localhost:8080/jobs", {
        jobId: jobId,
        jobTitle: jobTitle,
        jobDescription: jobDescription,
        departmentId: departmentId,
        minSal: minSal,
        maxSal: maxSal,
        locationId: locationId,
        userId: userId,
      });
      alert("Post created successfully");

      setJobId("");
      setJobTitle("");
      setJobDescription("");
      setDepartmentId("");
      setMinSal("");
      setMaxSal("");
      setLocationId("");
      setUserId("");
    } catch (err) {
      alert("Post creation failed");
    }
  }
  return (
    <div className="job-container">
      <form className="job-form" onSubmit={handleSubmit}>
        <br></br>
        <h1>Post job</h1>
        <p>Fill in the Information Below</p>


        <input
          type="text"
          name="jobTitle"
          placeholder="Job Title"
          onChange={(event) => {
            setJobTitle(event.target.value);
          }}
        />

        <input
          type="text"
          name="jobDescription"
          placeholder="Job Description"
          onChange={(event) => {
            setJobDescription(event.target.value);
          }}
        />

        <input
          type="number"
          name="departmentId"
          placeholder="Department"
          onChange={(event) => {
            setDepartmentId(event.target.value);
          }}
        />

        <input
          type="number"
          name="locationId"
          placeholder="Location"
          onChange={(event) => {
            setLocationId(event.target.value);
          }}
  
          />
         
    

        <h2 className="salary"> Salary range </h2>

        <input
          type="number"
          name="minSal"
          placeholder="Minimum Salary "
          onChange={(event) => {
            setMinSal(event.target.value);
          }}
        />

        <input
          type="number"
          name="maxSal"
          placeholder="Maximum Salary"
          onChange={(event) => {
            setMaxSal(event.target.value);
          }}
        />

        <button type="submit">Submit Job</button>
        <button type="submit">Save draft</button>

      </form>
    </div>
  );
}

export default JobPost;
