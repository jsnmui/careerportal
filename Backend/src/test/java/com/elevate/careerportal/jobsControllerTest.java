package com.elevate.careerportal;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.regex.Matcher;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@Import(jobsController.class)
@WebMvcTest(jobsController.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class jobsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private jobsDAO jobs;

    @MockBean
    JdbcTemplate template;

    @Test
    void testWelcome(){
        try {
            mockMvc.perform(get("/"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("Welcome to the PeopleShores CareerPortal!"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void postNewJob(){
        Jobs newJob = new Jobs(11,"Intern Software engineer",
                "Write code, learn , solve problems , profit", 1,400,1000,
                2,3);

        when(jobs.addJob(any(Jobs.class))).thenReturn(newJob);

        try {
            mockMvc.perform(post("/jobs")
                    .content("""
                            {
                                "userId" : 3,
                                "departmentId": 1,
                                "locationId": 2,
                                "jobTitle" : "Intern Software engineer",
                                "jobDescription" :  "Write code, learn , solve problems , profit",
                                "minSal" : 400,
                                "maxSal" : 1000
                            }
                            """)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().is(200))
                    .andExpect(MockMvcResultMatchers.jsonPath("jobId").value(11))
                    .andExpect(MockMvcResultMatchers.jsonPath("jobTitle").value("Intern Software engineer"))
                    .andExpect(MockMvcResultMatchers.jsonPath("jobDescription").value("Write code, learn , solve problems , profit"))
                    .andExpect(MockMvcResultMatchers.jsonPath("departmentId").value(1))
                    .andExpect(MockMvcResultMatchers.jsonPath("locationId").value(2))
                    .andExpect(jsonPath("$.*",Matchers.hasSize(12)))
                    .andExpect(MockMvcResultMatchers.jsonPath("userId").value(3))
                    .andExpect(MockMvcResultMatchers.jsonPath("minSal").value(400))
                    .andExpect(MockMvcResultMatchers.jsonPath("maxSal").value(1000))
                    .andExpect(MockMvcResultMatchers.jsonPath("active").value(true))
                    .andExpect(status().isOk()).andReturn();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
