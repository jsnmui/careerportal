package com.elevate.careerportal;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.ReflectionTestUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.mockito.*;
import org.mockito.Mockito.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import static org.mockito.ArgumentMatchers.any;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.test.util.ReflectionTestUtils;

class DBjobsDAOTest {

    private DBjobsDAO dBjobsDAO;

    @Mock

    private Jobs j;

    @Mock
    JdbcTemplate jdbcTemplate;

    @Before
    public void setUp() {
        jdbcTemplate = mock(JdbcTemplate.class);
        j = mock(Jobs.class);
        ReflectionTestUtils.setField(dBjobsDAO, "jdbcTemplate", jdbcTemplate);
    }

    @Test
    void addJob(){

//        Jobs j = new Jobs(11,"Intern Software engineer",
//                "Write code, learn , solve problems , profit", 1, LocalDateTime.parse("2022-12-10T05:00:00")
//                ,LocalDateTime.parse("2022-12-31T05:00:00"),
//                true,400,1000,2,3);


//        jdbcTemplate.update(j);

        //when(jdbcTemplate.query(anyString(), anyObject()).thenReturn(j);

//        when(jdbcTemplate.update("INSERT INTO careerportal.jobs (jobtitle," +
//                                                    "jobdescription,departmentid," +
//                                                    "postdate, postingenddate,isactive," +
//                                                    "minsal,maxsal,locationid,userid) " +
//                                                    "VALUES (?,?,?,?,?,?,?,?,?,?)"));
//
//        when(j.getDepartmentId()).thenReturn(3);
//        when(j.getJobTitle()).thenReturn("Intern Software engineer");
//        when(jdbcTemplate.update(j)).thenReturn(new Jobs(11,"Intern Software engineer",
//                  "Write code, learn , solve problems , profit", 1, LocalDateTime.parse("2022-12-10T05:00:00")
//                  ,LocalDateTime.parse("2022-12-31T05:00:00"),
//                  true,400,1000,2,3));
//        dBjobsDAO = new DBjobsDAO();
//        dBjobsDAO.addJob(j);
//        verify(jdbcTemplate).update(anyString(),anyString(),anyInt(),any(),any(),anyBoolean(),any(),any(),anyInt(),anyInt());

    }


}