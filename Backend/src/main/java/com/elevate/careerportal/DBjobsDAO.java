package com.elevate.careerportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Collection;

@Component
public class DBjobsDAO implements jobsDAO {
    @Autowired
    JdbcTemplate template;

    @Override
    public Jobs getById(Integer id) {
        Jobs j = template.queryForObject(
                "SELECT * FROM careerportal.jobs where jobid = ?",
                ((rs, rowNum) -> new Jobs(rs.getInt("jobid"), rs.getString("jobtitle"), rs.getString("jobdescription"),rs.getInt("departmentid"),rs.getObject("minsal",Integer.class),rs.getObject("maxsal",Integer.class),rs.getInt("locationid"),rs.getInt("userid"))),
                id
        );
        return j;
    }


    @Override
  public Collection<Jobs> getAlljobs() {
        return template.query("SELECT * FROM careerportal.jobs",
                (rs, rowNum) -> (new Jobs( rs.getInt("jobid"), rs.getString("jobtitle"), rs.getString("jobdescription"),rs.getInt("departmentid"),rs.getObject("minsal",Integer.class),rs.getObject("maxsal",Integer.class),rs.getInt("locationid"),rs.getInt("userid"))), new Object[] {});
    }

    @Override
    public Jobs addJob(Jobs jobs) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(connection -> {
                    PreparedStatement ps = connection.prepareStatement
                            ("INSERT INTO careerportal.jobs (jobtitle," +
                                            "jobdescription,departmentid," +
                                            "minsal,maxsal,locationid,userid) " +
                                            "VALUES (?,?,?,?,?,?,?)",
                            Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, jobs.getJobTitle());
                    ps.setString(2, jobs.getJobDescription());
                    ps.setInt(3, jobs.getDepartmentId());
                    ps.setObject(4, jobs.getMinSal());
                    ps.setObject(5, jobs.getMaxSal());
                    ps.setInt(6, jobs.getLocationId());
                    ps.setInt(7, jobs.getUserId());
                    return ps;}
                ,keyHolder);
        return getById((Integer)keyHolder.getKeys().get("jobid"));
    }


    @Override
    public int getJobsCount() {
        int count = template.queryForObject("select count(0) from careerportal.jobs", Integer.class);
        return count;
    }

}
