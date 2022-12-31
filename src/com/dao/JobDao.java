package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.bean.Dept;
import com.bean.Job;
import com.bean.User;
import com.dao.pro.JobDaoPro;
import com.dao.pro.UserDaoPro;

@Repository("jobDao")
public interface JobDao {
	
	@SelectProvider(method = "selectJob", type = JobDaoPro.class)
	public List<Job> selectJob(Map m);
	
	@SelectProvider(method = "selectJobCount", type = JobDaoPro.class)
	public int selectJobCount(Job j);
	
	@Insert("insert into job_inf(name,remark) value(#{name},#{remark})")
	public int addJob(Job j);
	
	@Delete("delete from job_inf where id=#{id}")
	public int deleteJob(int id);
	
	@Select("select * from job_inf where id=#{id}")
	public Job selectJobById(int id);
	
	@Update("update job_inf set name=#{name},remark=#{remark} where id=#{id}")
	public int updateJob(Job j);
	
	@Select("select * from job_inf")
	public List<Job> selectAllJob();
}
