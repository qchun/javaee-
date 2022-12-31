package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.User;

@Controller
public class FormController {
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(User u,HttpSession hs){
		if(u!=null){
			hs.removeAttribute("user");
			hs.invalidate();
		}
		return "login";
	}
	@RequestMapping("/{f}")
	public String f(@PathVariable String f){
		return f;
	}
}
