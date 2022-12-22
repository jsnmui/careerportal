async function handleUpdate(event) {
  event.preventDefault();
  try {
    await axios.put(`http://localhost:8080/jobs/${id}`, {
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
    alert("Job updated successfully");
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
    alert("Job update failed");
  }
}