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
import com.bean.User;
import com.dao.pro.DeptDaoPro;
import com.dao.pro.UserDaoPro;

@Repository("deptDao")
public interface DeptDao {
	
	@SelectProvider(method = "selectDept", type = DeptDaoPro.class)
	public List<Dept> selectDept(Map m);
	
	@SelectProvider(method = "selectDeptCount", type = DeptDaoPro.class)
	public int selectDeptCount(Dept d);
	
	@Insert("insert into dept_inf(name,remark) value(#{name},#{remark})")
	public int addDept(Dept d);
	
	@Delete("delete from dept_inf where id=#{id}")
	public int deleteDept(int id);
	
	@Select("select * from dept_inf where id=#{id}")
	public Dept selectDeptById(int id);
	
	@Update("update dept_inf set name=#{name},remark=#{remark} where id=#{id}")
	public int updateDept(Dept d);
	
	@Select("select * from dept_inf")
	public List<Dept> selectAllDept();
}
