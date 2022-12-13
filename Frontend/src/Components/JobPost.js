import React from "react";
import axios from "axios";
import { useState } from "react";
import "../Styles/JobPost.css";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

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

  const [value, setValue] = useState("");
  const handleChange = (event) => {
    // Get the selected option from the <datalist> element
    const options = event.target.form.elements.options;
    const selectedOption = options.options[options.selectedIndex];

    // Update the value state variable with the selected option
    setValue(selectedOption.value);
  };

  async function handleSubmit(event) {
    event.preventDefault();
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
        />
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
          type="text"
          name="locationId"
          list="options"
          placeholder="Location"
          onChange={(event) => {
            setLocationId(event.target.value);
          }}
        />
        <datalist id="options">
          <option value="1. New York" />
          <option value="2. Clarksdale" />
          <option value="3. Atlanta" />
        </datalist>

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

        <DatePicker
          className="datePicker"
          selected={postDate}
          name="startDate"
          onChange={(date) => setPostDate(date)}
          isClearable
          placeholderText="Post Date"
        />

        <DatePicker
          className="datePicker"
          selected={postingEndDate}
          name="endDate"
          onChange={(date) => setPostingEndDate(date)}
          isClearable
          placeholderText="End Post Date"
        />

        <button type="submit">Submit Job</button>
        <button type="submit">Save draft</button>
      </form>
    </div>
  );
}

export default JobPost;
