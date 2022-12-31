package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.Job;
import com.bean.User;
import com.manager.PageManager;
import com.service.JobService;
import com.service.UserService;

@Controller
public class JobController {
	@Resource(name="jobService")		//@Autowired
	JobService jobService;
	
	@RequestMapping("/selectJob")
	public String selectJob(Job j,Integer pageNow,Model m){
		if(pageNow==null) pageNow=1;
		int totalSize = jobService.selectJobCount(j);
		PageManager pm = new PageManager(pageNow,10,totalSize);
		Map map = new HashMap();
		map.put("job", j);
		map.put("pm", pm);
		List<Job> jobList=jobService.selectJob(map);
		m.addAttribute("jobList", jobList);
		m.addAttribute("job", j);
		m.addAttribute("pm", pm);
		return "job/selectJob";
	}
	
	@RequestMapping("/addJobView")
	public String addJobView(){
		return "job/addJobView";
	}
	
	@RequestMapping("/addJob")
	public String addJob(Job j,Model m){
		int i = jobService.addJob(j);
		if(i==1){
			return "redirect:selectJob";
		}else{
			m.addAttribute("msg","Ìí¼ÓÊ§°Ü");
			return "fail";
		}
	}
	
	@RequestMapping("/deleteJob")
	public String deleteJob(int id,Model m){
		int i = jobService.deleteJob(id);
		if(i==1){
			return "redirect:selectJob";
		}else{
			m.addAttribute("msg","É¾³ýÊ§°Ü");
			return "fail";
		}
	}
	
	@RequestMapping("/deleteJobs")
	public String deleteJobs(int[] ids){
		jobService.deleteJobs(ids);
		return "redirect:selectJob";
	}
	
	@RequestMapping("/updateJobView")
	public String updateJobView(int id,Model m){
		Job job = jobService.selectJobById(id);
		m.addAttribute("job", job);
		return "job/updateJobView";
	}
	
	@RequestMapping("/updateJob")
	public String updateJob(Job j,Model m){
		int i = jobService.updateJob(j);
		if(i==1){
			return "redirect:selectJob";
		}else{
			m.addAttribute("msg","ÐÞ¸ÄÊ§°Ü");
			return "fail";
		}
	}
}
