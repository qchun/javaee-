package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.User;
import com.manager.PageManager;
import com.service.UserService;

@Controller
public class UserController {
	@Resource(name="userService")		//@Autowired
	UserService userService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(User u,HttpSession hs,Model m){
		User user=userService.login(u);
		if(user==null){
			m.addAttribute("msg","µ«»Î ß∞‹");
			return "fail";
		}else{
			hs.setAttribute("user", user);
			return "index";
		}
	}
	
	@RequestMapping("/selectUser")
	public String selectUser(User u,Integer pageNow,Model m){
		if(pageNow==null) pageNow=1;
		int totalSize = userService.selectUserCount(u);
		PageManager pm = new PageManager(pageNow,5,totalSize);
		Map map = new HashMap();
		map.put("user", u);
		map.put("pm", pm);
		List<User> userList=userService.selectUser(map);
		m.addAttribute("userList", userList);
		m.addAttribute("user", u);
		m.addAttribute("pm", pm);
		return "user/user_select";
	}
	
	@RequestMapping("/addUserView")
	public String addUserView(){
		return "user/addUserView";
	}
	
	@RequestMapping("/addUser")
	public String addUser(User u,Model m){
		int i = userService.addUser(u);
		if(i==1){
			return "redirect:selectUser";
		}else{
			m.addAttribute("msg","ÃÌº” ß∞‹");
			return "fail";
		}
	}
	
	@RequestMapping("/deleteUser")
	public String deleteUser(int id,Model m,HttpSession hs){
		User user = (User)hs.getAttribute("user");
		if(user.getId()==id){
			m.addAttribute("msg", "≤ªƒ‹…æ≥˝±æ»À”√ªß");
			return "fail";
		}
		int i = userService.deleteUser(id);
		if(i==1){
			return "redirect:selectUser";
		}else{
			m.addAttribute("msg","…æ≥˝ ß∞‹");
			return "fail";
		}
	}
	
	@RequestMapping("/deleteUsers")
	public String deleteUsers(int[] ids){
		userService.deleteUsers(ids);
		return "redirect:selectUser";
	}
	
	@RequestMapping("/updateUserView")
	public String updateUserView(int id,Model m){
		User user = userService.selectUserById(id);
		m.addAttribute("user", user);
		return "user/updateUserView";
	}
	
	@RequestMapping("/updateUser")
	public String updateUser(User u,Model m){
		int i = userService.updateUser(u);
		if(i==1){
			return "redirect:selectUser";
		}else{
			m.addAttribute("msg","–ﬁ∏ƒ ß∞‹");
			return "fail";
		}
	}
}
