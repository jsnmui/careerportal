package com.elevate.careerportal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import static org.mockito.ArgumentMatchers.any;
import org.springframework.jdbc.support.KeyHolder;
@WebMvcTest(DBjobsDAO.class)
@ContextConfiguration(locations="classpath:testbeans.xml")
class DBjobsDAOTest {

    @Mock
    JdbcTemplate template;
    @Mock
    KeyHolder keyHolder;

    @Test
   public void whenMockJdbc_thenReturnJobId1(){
                DBjobsDAO j = new DBjobsDAO();
               Jobs job = new Jobs(1, "Job", "Job Description", 12, LocalDateTime.parse("2022-12-10T05:00:00")
                                , LocalDateTime.parse("2022-12-10T05:00:00")
                               , null, null, null, null, 21);
               ReflectionTestUtils.setField(j, "template", template);
//               when(template.queryForObject(anyString(), any(RowMapper.class), any())).thenReturn(job);
//                assertEquals(job, j.getById(1));

      Map<String,Object> map = new HashMap<>();
        map.put("jobid",1);
        map.put("jobTitle","Job");
        map.put("jobDescription","Job Description");
        map.put("departmentId",0);
        map.put("postDate",LocalDateTime.parse("2022-12-10T05:00:00"));
        map.put("postingEndDate",LocalDateTime.parse("2022-12-10T05:00:00"));
        map.put("isActive",null);
        map.put("minSal",0);
        map.put("maxSal",2);
        map.put("locationId",null);
        map.put("userId",1);


        when(keyHolder.getKeys()).thenReturn(map);
           //     j.addJob(job);
//        verify(template).update(anyString(),anyString(),anyInt(),any(),any(),anyBoolean(),any(),any(),anyInt(),anyInt());
           }
}