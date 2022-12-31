package com.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Dept;
import com.bean.User;
import com.dao.UserDao;

@Service("userService")
public class UserService {
	@Resource(name="userDao")		//@Autowired
	UserDao userdao;
	
	public User login(User u){
		return userdao.login(u);
	}
	
	public List<User> selectUser(Map m){
		return userdao.selectUser(m);
	}
	
	public int selectUserCount(User u){
		return userdao.selectUserCount(u);
	}
	
	public int addUser(User u){
		return userdao.addUser(u);
	}
	
	public int deleteUser(int id){
		return userdao.deleteUser(id);
	}
	
	public void deleteUsers(int[] ids){
		for(int i=0;i<ids.length;i++){
			userdao.deleteUser(ids[i]);
		}
	}
	
	public User selectUserById(int id){
		return userdao.selectUserById(id);
	}
	
	public int updateUser(User u){
		return userdao.updateUser(u);
	}
	
	public List<User> selectAllUser(){
		return userdao.selectAllUser();
	}
}
