package com.elevate.careerportal;

import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public interface jobsDAO {
    Jobs getById(Integer id);
//    //
//   Collection<Jobs> getAlljobs();

   Jobs addJob(Jobs jobs);

//    int getJobsCount();


}
