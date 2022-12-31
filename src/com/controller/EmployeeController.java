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

import com.bean.Dept;
import com.bean.Employee;
import com.bean.Job;
import com.bean.User;
import com.manager.PageManager;
import com.service.DeptService;
import com.service.EmployeeService;
import com.service.JobService;
import com.service.UserService;

@Controller
public class EmployeeController {
	@Resource(name="employeeService")		//@Autowired×Ô¶¯Æ¥Åä
	EmployeeService employeeService;
	@Resource(name="deptService")
	DeptService deptService;
	@Resource(name="jobService")
	JobService jobService;
	
	@RequestMapping("/selectEmployee")
	public String selectEmployee(Employee e,Integer pageNow,Model m,HttpSession hs){
		if(pageNow==null) pageNow=1;
		int totalSize = employeeService.selectEmployeeCount(e);
		PageManager pm = new PageManager(pageNow,5,totalSize);
		Map map = new HashMap();
		map.put("employee", e);
		map.put("pm", pm);
		List<Employee> employeeList=employeeService.selectEmployee(map);
		m.addAttribute("employeeList", employeeList);
		m.addAttribute("employee", e);
		m.addAttribute("pm", pm);
		
		List<Dept> deptList = deptService.selectAllDept();
		//m.addAttribute("deptList", deptList);
		List<Job> jobList = jobService.selectAllJob();
		//m.addAttribute("jobList", jobList);
		hs.setAttribute("deptList", deptList);
		hs.setAttribute("jobList", jobList);
		return "employee/selectEmployee";
	}
	
	@RequestMapping("/addEmployeeView")
	public String addEmployeeView(HttpSession hs){
		List<Job> jobList = (List<Job>) hs.getAttribute("jobList");
		List<Dept> deptList = (List<Dept>) hs.getAttribute("deptList");
		if(jobList==null){
			jobList = jobService.selectAllJob();
			hs.setAttribute("jobList", jobList);
		}
		if(deptList==null){
			deptList = deptService.selectAllDept();
			hs.setAttribute("deptList", deptList);
		}
		return "employee/addEmployeeView";
	}
	
	@RequestMapping("/addEmployee")
	public String addEmployee(Employee e,Model m){
		int i = employeeService.addEmployee(e);
		if(i==1){
			return "redirect:selectEmployee";
		}else{
			m.addAttribute("msg","Ìí¼ÓÊ§°Ü");
			return "fail";
		}
	}
	
	@RequestMapping("/deleteEmployee")
	public String deleteEmployee(int id,Model m){
		int i = employeeService.deleteEmployee(id);
		if(i==1){
			return "redirect:selectEmployee";
		}else{
			m.addAttribute("msg","É¾³ýÊ§°Ü");
			return "fail";
		}
	}
	
	@RequestMapping("/deleteEmployees")
	public String deleteEmployees(int[] ids){
		employeeService.deleteEmployees(ids);
		return "redirect:selectEmployee";
	}
	
	@RequestMapping("/updateEmployeeView")
	public String updateEmployeeView(int id,Model m){
		Employee employee = employeeService.selectEmployeeById(id);
		m.addAttribute("employee", employee);
		/*List<Dept> deptList = deptService.selectAllDept();
		m.addAttribute("deptList", deptList);
		List<Job> jobList = jobService.selectAllJob();
		m.addAttribute("jobList", jobList);*/
		return "employee/updateEmployeeView";
	}
	
	@RequestMapping("/updateEmployee")
	public String updateEmployee(Employee e,Model m){
		int i = employeeService.updateEmployee(e);
		if(i==1){
			return "redirect:selectEmployee";
		}else{
			m.addAttribute("msg","ÐÞ¸ÄÊ§°Ü");
			return "fail";
		}
	}
}
