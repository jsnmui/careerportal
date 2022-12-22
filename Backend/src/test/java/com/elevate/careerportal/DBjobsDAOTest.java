package com.elevate.careerportal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import java.util.HashMap;
import java.util.Map;
import static org.mockito.Mockito.*;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.KeyHolder;
import static org.mockito.ArgumentMatchers.any;
@WebMvcTest(DBjobsDAO.class)
@ContextConfiguration(locations="classpath:beans.xml")
class DBjobsDAOTest {

    @MockBean
    JdbcTemplate template;

    @MockBean
    KeyHolder keyholder;

    @Test
    public void addJobTest(){
        keyholder = mock(KeyHolder.class);
        DBjobsDAO j = spy (new DBjobsDAO());

        Jobs job = new Jobs(3, null, null, null, null, null
                , null, null, null, null, 0);
        ReflectionTestUtils.setField(j, "template", template);


        Map<String,Object> map = new HashMap<>();
        map.put("jobid",job.getJobId());

        when(j.newKeyHolder()).thenReturn(keyholder);
        when(keyholder.getKeys()).thenReturn(map);

        j.addJob(job);
        verify(j).newKeyHolder();
        verify(template).update(any(PreparedStatementCreator.class),eq(keyholder));
        verify(template).update(any(PreparedStatementCreator.class),any(KeyHolder.class));
        verify(template).update(any(PreparedStatementCreator.class));
        verify(j).getById(3);
    }
}