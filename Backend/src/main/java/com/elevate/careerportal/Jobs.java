package com.elevate.careerportal;

import java.time.LocalDateTime;

public class Jobs {
  private int jobId;
  private String jobTitle;
  private String jobDescription;
  private int departmentId;
  private LocalDateTime postDate;

  private LocalDateTime postingEndDate;

  private boolean isActive;
  private int locationId;
  private int userId;
  private Integer minSal;
  private Integer maxSal;

    public LocalDateTime getPostingEndDate() {
        return postingEndDate;
    }

    public Integer getMinSal() {
        return minSal;
    }

    public Integer getMaxSal() {
        return maxSal;
    }

    public String getJobTitle() {
        return jobTitle;
    }

   public String getJobDescription() {
        return jobDescription;
   }

    public int getDepartmentId() {
        return departmentId;
    }

    public LocalDateTime getPostDate() {
        return postDate;
    }


    public boolean getIsActive() {
        return isActive;
    }

    public int getLocationId() {
        return locationId;
    }

    public int getUserId() {
        return userId;
    }
    public int getJobId() {
        return jobId;
    }

    public Jobs(int jobId, String jobTitle, String jobDescription, int departmentId, LocalDateTime postDate, LocalDateTime postingEndDate, Boolean isActive, Integer minSal, Integer maxSal, String locationId, int userId) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.departmentId = departmentId;
        this.postDate = postDate;
        this.postingEndDate =  postingEndDate;
        this.isActive = true;
        this.minSal = minSal;
        this.maxSal = maxSal;
        if (locationId != null && !locationId.isEmpty() && !locationId.isBlank()){
            String[] arr = locationId.split(". ", 2);
            this.locationId = Integer.parseInt(arr[0]);
        }
        this.userId = userId;
    }




}
