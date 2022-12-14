package com.elevate.careerportal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DBjobsDAOTest {

      DBjobsDAO dao =  new DBjobsDAO();

     @Mock
    private Jobs jobs;

   @Mock
    private JdbcTemplate template;

    @BeforeEach
    public void setUp() {

        ReflectionTestUtils.setField(dao, "template", template);
    }


    @Test
    void addJob() {

    }
}