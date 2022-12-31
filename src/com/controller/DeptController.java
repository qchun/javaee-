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
import com.bean.User;
import com.manager.PageManager;
import com.service.DeptService;
import com.service.UserService;

@Controller
public class DeptController {
	@Resource(name="deptService")		//@Autowired
	DeptService deptService;
	
	@RequestMapping("/selectDept")
	public String selectDept(Dept d,Integer pageNow,Model m){
		if(pageNow==null) pageNow=1;
		int totalSize = deptService.selectDeptCount(d);
		PageManager pm = new PageManager(pageNow,10,totalSize);
		Map map = new HashMap();
		map.put("dept", d);
		map.put("pm", pm);
		List<Dept> deptList=deptService.selectDept(map);
		m.addAttribute("deptList", deptList);
		m.addAttribute("dept", d);
		m.addAttribute("pm", pm);
		return "dept/selectDept";
	}
	
	@RequestMapping("/addDeptView")
	public String addDeptView(){
		return "dept/addDeptView";
	}
	
	@RequestMapping("/addDept")
	public String addDept(Dept d,Model m){
		int i = deptService.addDept(d);
		if(i==1){
			return "redirect:selectDept";
		}else{
			m.addAttribute("msg","Ìí¼ÓÊ§°Ü");
			return "fail";
		}
	}
	
	@RequestMapping("/deleteDept")
	public String deleteDept(int id,Model m){
		int i = deptService.deleteDept(id);
		if(i==1){
			return "redirect:selectDept";
		}else{
			m.addAttribute("msg","É¾³ýÊ§°Ü");
			return "fail";
		}
	}
	
	@RequestMapping("/deleteDepts")
	public String deleteDepts(int[] ids){
		deptService.deleteDepts(ids);
		return "redirect:selectDept";
	}
	
	@RequestMapping("/updateDeptView")
	public String updateDeptView(int id,Model m){
		Dept dept = deptService.selectDeptById(id);
		m.addAttribute("dept", dept);
		return "dept/updateDeptView";
	}
	
	@RequestMapping("/updateDept")
	public String updateDept(Dept d,Model m){
		int i = deptService.updateDept(d);
		if(i==1){
			return "redirect:selectDept";
		}else{
			m.addAttribute("msg","ÐÞ¸ÄÊ§°Ü");
			return "fail";
		}
	}
}
