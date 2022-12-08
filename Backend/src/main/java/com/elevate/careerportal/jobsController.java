package com.elevate.careerportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
@CrossOrigin(origins = "http://localhost", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
//@CrossOrigin (origins = "http://localhost:3000")
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

    @GetMapping(value="/count")
    public String getCount() throws Exception {

        int count = jobs.getJobsCount();
        return "Table has " + count + " jobs";
    }

    @GetMapping(value="/jobs/{id}")
    public Jobs getPublisher(@PathVariable int id) {
        return jobs.getById(id);
    }
    @GetMapping(value="/jobs")
    public Collection<Jobs> getAlljobs() {
        return jobs.getAlljobs();
    }

    @PostMapping(value="/jobs")
    public Jobs newJob(@RequestBody Jobs jobs) {
        return this.jobs.addJob(jobs);
    }

}
