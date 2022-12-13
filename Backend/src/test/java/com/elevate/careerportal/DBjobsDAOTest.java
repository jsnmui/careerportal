package com.elevate.careerportal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DBjobsDAOTest {

      DBjobsDAO dao =  new DBjobsDAO();

    @Mock
    private Jobs jobs;

    @MockBean
    private JdbcTemplate template;

    @BeforeEach
    public void setUp() {
      template =mock(JdbcTemplate.class);
        jobs=mock(Jobs.class);
        ReflectionTestUtils.setField(dao, "template", template);
    }


    @Test
    void addJob() {
    dao.addJob(jobs);

    }
}