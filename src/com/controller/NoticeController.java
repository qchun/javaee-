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
import com.bean.Notice;
import com.bean.User;
import com.manager.PageManager;
import com.service.DeptService;
import com.service.EmployeeService;
import com.service.JobService;
import com.service.NoticeService;
import com.service.UserService;

@Controller
public class NoticeController {
	@Resource(name="noticeService")		//@Autowired×Ô¶¯Æ¥Åä
	NoticeService noticeService;
	@Resource(name="userService")
	UserService userService;
	
	@RequestMapping("/selectNotice")
	public String selectNotice(Notice n,Integer pageNow,Model m,HttpSession hs){
		if(pageNow==null) pageNow=1;
		int totalSize = noticeService.selectNoticeCount(n);
		PageManager pm = new PageManager(pageNow,5,totalSize);
		Map map = new HashMap();
		map.put("notice", n);
		map.put("pm", pm);
		List<Notice> noticeList=noticeService.selectNotice(map);
		m.addAttribute("noticeList", noticeList);
		m.addAttribute("notice", n);
		m.addAttribute("pm", pm);
		
		List<User> userList = userService.selectAllUser();
		hs.setAttribute("userList", userList);
		return "notice/selectNotice";
	}
	
	@RequestMapping("/addNoticeView")
	public String addNoticeView(HttpSession hs){
		return "notice/addNoticeView";
	}
	
	@RequestMapping("/addNotice")
	public String addNotice(Notice n,Model m,HttpSession hs){
		User user = (User) hs.getAttribute("user");
		n.setUser_id(user.getId());
		int i = noticeService.addNotice(n);
		if(i==1){
			return "redirect:selectNotice";
		}else{
			m.addAttribute("msg","Ìí¼ÓÊ§°Ü");
			return "fail";
		}
	}
	
	@RequestMapping("/deleteNotice")
	public String deleteNotice(int id,Model m){
		int i = noticeService.deleteNotice(id);
		if(i==1){
			return "redirect:selectNotice";
		}else{
			m.addAttribute("msg","É¾³ýÊ§°Ü");
			return "fail";
		}
	}
	
	@RequestMapping("/deleteNotices")
	public String deleteNotices(int[] ids){
		noticeService.deleteNotices(ids);
		return "redirect:selectNotice";
	}
	
	@RequestMapping("/updateNoticeView")
	public String updateNoticeView(int id,Model m){
		Notice notice = noticeService.selectNoticeById(id);
		m.addAttribute("notice", notice);
		return "notice/updateNoticeView";
	}
	
	@RequestMapping("/updateNotice")
	public String updateNotice(Notice n,Model m,HttpSession hs){
		User user = (User) hs.getAttribute("user");
		n.setUser_id(user.getId());
		int i = noticeService.updateNotice(n);
		if(i==1){
			return "redirect:selectNotice";
		}else{
			m.addAttribute("msg","ÐÞ¸ÄÊ§°Ü");
			return "fail";
		}
	}
	
	@RequestMapping("/ylNoticeView")
	public String ylNoticeView(int id,Model m){
		Notice notice = noticeService.selectNoticeById(id);
		m.addAttribute("notice", notice);
		return "notice/ylNoticeView";
	}
}
