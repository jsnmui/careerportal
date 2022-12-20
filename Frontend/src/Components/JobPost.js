import React from "react";
import axios from "axios";
import { useState } from "react";
import "../Styles/JobPost.css";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import Dropdown from "./Dropdown";
// import DropdownList from "react-widgets/DropdownList";

function JobPost() {

  const [jobId, setJobId] = useState("");
  const [jobTitle, setJobTitle] = useState("");
  const [jobDescription, setJobDescription] = useState("");
  const [departmentId, setDepartmentId] = useState("");
  const [postDate, setPostDate] = useState(new Date());
  const [postingEndDate, setPostingEndDate] = useState(new Date());
  const [minSal, setMinSal] = useState("");
  const [maxSal, setMaxSal] = useState("");
  const [locationId, setLocationId] = useState("");
  const [userId, setUserId] = useState("");

  const options = [
    {value : "one", label: "1. New York"},
    {value : "two", label: "2. Clarksdale"},
    {value : "three", label: "3. Atlanta"},
  ]
   
  

  // const [value, setValue] = useState("Red");

  // var searchNames = ['Sydney', 'Melbourne', 'Brisbane', 
  // 'Adelaide', 'Perth', 'Hobart'];

  async function handleSubmit(event) {
    try {
      await axios.post("http://localhost:8080/jobs", {
        userId: userId,
        jobId: jobId,
        jobTitle: jobTitle,
        jobDescription: jobDescription,
        departmentId: departmentId,
        postDate: postDate,
        postingEndDate: postingEndDate,
        minSal: minSal,
        maxSal: maxSal,
        locationId: locationId,
      });
      alert("Post created successfully");
      setUserId("");
      setJobId("");
      setJobTitle("");
      setJobDescription("");
      setDepartmentId("");
      setPostDate("");
      setPostingEndDate("");
      setMinSal("");
      setMaxSal("");
      setLocationId("");
    } catch (err) {
      alert("Post creation failed");
    }
    event.preventDefault();
  }

  return (
    <div className="job-container">
      <form className="job-form" onSubmit={handleSubmit}>
        <br></br>
        <h1>Post job</h1>
        <p>Fill in the Information Below</p>
        <input
          type="number"
          name="userId"
          placeholder="Testing User ID"
          onChange={(event) => {
            setUserId(event.target.value);
          }}
          value={userId}
        />
        
        <input
          type="text"
          name="jobTitle"
          placeholder="Job Title"
          onChange={(event) => {
            setJobTitle(event.target.value);
          }}
          value={jobTitle}
        />

        <textarea
          type="text"
          name="jobDescription"
          placeholder="Job Description"
          onChange={(event) => {
            setJobDescription(event.target.value);
          }}
          value={jobDescription}
        />

        <input
          type="text"
          name="depatmentid"
          list="options"
          placeholder="Department"
          onChange={(event) => {
            setDepartmentId(event.target.value);
          }}
          value={departmentId}
        />
      {/* <Dropdown placeHolder="Select..." options={options}/> */}

        <datalist id="options">
          <option value="1. Morgan Stanley" />
          <option value="2. Department of education" />
        </datalist>

        <input
          type="text"
          name="locationId"
          list="options2"
          placeholder="Location"
          onChange={(event) => {
            setLocationId(event.target.value);
          }}
          // value={locationId}
        />
        <datalist id="options2">
          <option value="1. New York" />
          <option value="2. Clarksdale" />
          <option value="3. Atlanta" />
        </datalist>





    {/* <DropdownList
      value={value}
      onChange={(nextValue) => setValue(nextValue)}
      data={["Yellow", "Red", "Blue"]}
    /> */}

          {/* <DropdownInput 
              options={searchNames}
              defaultValue={this.props.initialValue}
              menuClassName='dropdown-input'
              onSelect={this.handleSelectName}
              placeholder='Search...'
          /> */}
        <h2 className="salary"> Salary range </h2>
        
        <input
          type="number"
          name="minSal"
          placeholder="Minimum Salary "
          onChange={(event) => {
            setMinSal(event.target.value);
          }}
          value={minSal}
        />

        <input
          type="number"
          name="maxSal"
          placeholder="Maximum Salary"
          onChange={(event) => {
            setMaxSal(event.target.value);
          }}
          value={maxSal}
        />

        <DatePicker
          className="datePicker"
          selected={postDate}
          name="postDate"
          onChange={(date) => setPostDate(date)}
          isClearable
          placeholderText="Post Date"
          value={postDate}
        />

        <DatePicker
          className="datePicker"
          selected={postingEndDate}
          name="postingEndDate"
          onChange={(date) => setPostingEndDate(date)}
          isClearable
          placeholderText="End Post Date"
          value={postingEndDate}
        />
        {/* <button type="submit" value="Submit"> */}
        <button type="submit" onClick={handleSubmit}>
          Submit Job
        </button>
        <button type="submit">Save draft</button>
      </form>
    </div>
  );
}

export default JobPost;
