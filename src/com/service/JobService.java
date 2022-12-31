package com.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Job;
import com.bean.User;
import com.dao.JobDao;
import com.dao.UserDao;

@Service("jobService")
public class JobService {
	@Resource(name="jobDao")		//@Autowired
	JobDao jobdao;
	
	public List<Job> selectJob(Map m){
		return jobdao.selectJob(m);
	}
	
	public int selectJobCount(Job j){
		return jobdao.selectJobCount(j);
	}
	
	public int addJob(Job j){
		return jobdao.addJob(j);
	}
	
	public int deleteJob(int id){
		return jobdao.deleteJob(id);
	}
	
	public void deleteJobs(int[] ids){
		for(int i=0;i<ids.length;i++){
			jobdao.deleteJob(ids[i]);
		}
	}
	
	public Job selectJobById(int id){
		return jobdao.selectJobById(id);
	}
	
	public int updateJob(Job j){
		return jobdao.updateJob(j);
	}
	
	public List<Job> selectAllJob(){
		return jobdao.selectAllJob();
	}
}
