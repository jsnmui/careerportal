package com.elevate.careerportal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@WebMvcTest(DBjobsDAO.class)
@ContextConfiguration(locations="classpath:testbeans.xml")
class DBjobsDAOTest {

    @Mock
    JdbcTemplate template;
    @Test
   public void whenMockJdbc_thenReturnJobId1(){
                DBjobsDAO j = new DBjobsDAO();
               Jobs job = new Jobs(1, "Job", "Job Description", 12, LocalDateTime.parse("2022-12-10T05:00:00")
                                , LocalDateTime.parse("2022-12-10T05:00:00")
                               , null, null, null, null, 21);
               ReflectionTestUtils.setField(j, "template", template);
               when(template.queryForObject(anyString(), any(RowMapper.class), any())).thenReturn(job);
                assertEquals(job, j.getById(1));
           }
}