package com.elevate.careerportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RestController
@RequestMapping
public class jobsController {
    @Autowired
    private jobsDAO jobs;

    @Autowired
    JdbcTemplate template;

    @GetMapping(value="/")
    public String index() {
        return "Welcome to the PeopleShores CareerPortal!";
    }

  //  @GetMapping(value="/jobs/{id}")
//    public Jobs getJobbyID(@PathVariable int id) {
//        return jobs.getById(id);
//    }
    @GetMapping(value="/jobs")
    public Collection<Jobs> getAlljobs() {
        return jobs.getAlljobs();
    }



    @PostMapping(value="/jobs")
    public Jobs addJob(@Valid @RequestBody Jobs jobs) {
        return this.jobs.addJob(jobs);
    }
//
//    @PutMapping(value="/archive")
//    void update(@RequestBody Jobs jobs) {
//        this.jobs.update(jobs);
//    }

}
