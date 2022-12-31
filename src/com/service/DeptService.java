package com.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Dept;
import com.bean.User;
import com.dao.DeptDao;
import com.dao.UserDao;

@Service("deptService")
public class DeptService {
	@Resource(name="deptDao")		//@Autowired
	DeptDao deptdao;
	
	public List<Dept> selectDept(Map m){
		return deptdao.selectDept(m);
	}
	
	public int selectDeptCount(Dept d){
		return deptdao.selectDeptCount(d);
	}
	
	public int addDept(Dept d){
		return deptdao.addDept(d);
	}
	
	public int deleteDept(int id){
		return deptdao.deleteDept(id);
	}
	
	public void deleteDepts(int[] ids){
		for(int i=0;i<ids.length;i++){
			deptdao.deleteDept(ids[i]);
		}
	}
	
	public Dept selectDeptById(int id){
		return deptdao.selectDeptById(id);
	}
	
	public int updateDept(Dept d){
		return deptdao.updateDept(d);
	}
	
	public List<Dept> selectAllDept(){
		return deptdao.selectAllDept();
	}
}
