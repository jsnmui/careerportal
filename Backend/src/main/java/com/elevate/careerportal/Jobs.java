package com.elevate.careerportal;

import java.time.LocalDateTime;

public class Jobs {
  private int jobId;
  private String jobTitle;
  private String jobDescription;
  private int departmentId;
  private LocalDateTime postDate;

  private LocalDateTime postingEndDate;
  private LocalDateTime archiveDate;
  private boolean isActive = true;
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

    public LocalDateTime getArchiveDate() {
        return archiveDate;
    }

    public boolean isActive() {
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

    public Jobs(int jobId, String jobTitle, String jobDescription, int departmentId, Integer minSal, Integer maxSal, int locationId, int userId) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.departmentId = departmentId;
        this.postDate = LocalDateTime.now();
        if (this.isActive == false) {
            this.archiveDate = LocalDateTime.now();
        }
        this.minSal = minSal;
        this.maxSal = maxSal;
        this.locationId = locationId;
        this.userId = userId;
    }




}
