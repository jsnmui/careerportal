package com.elevate.careerportal;

import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public interface jobsDAO {
    Jobs getById(Integer id);
//    //
   Collection<Jobs> getAlljobs();

   Jobs addJob(Jobs jobs);

//   void update(Jobs jobs);
   KeyHolder newKeyHolder();
}
