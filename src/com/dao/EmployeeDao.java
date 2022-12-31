package com.dao;

import java.util.List;

import java.util.Map;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;
import com.bean.Employee;
import com.dao.pro.EmployeeDaoPro;

@Repository("employeeDao")
public interface EmployeeDao {
	
	@SelectProvider(method = "selectEmployee", type = EmployeeDaoPro.class)
	@Results({
		@Result(property="dept",column="dept_id",one=@One(select="com.dao.DeptDao.selectDeptById",fetchType=FetchType.LAZY)),
		@Result(property="job",column="job_id",one=@One(select="com.dao.JobDao.selectJobById",fetchType=FetchType.LAZY))
	})
	public List<Employee> selectEmployee(Map m);
	
	@SelectProvider(method = "selectEmployeeCount", type = EmployeeDaoPro.class)
	public int selectEmployeeCount(Employee e);
	
	@Insert("insert into employee_inf(dept_id,job_id,name,card_id,address,post_code,tel,phone,qq_num,email,sex,party,birthday,race,education,speciality,hobby,remark)" +
			" value(#{dept_id},#{job_id},#{name},#{card_id},#{address},#{post_code},#{tel},#{phone},#{qq_num},#{email},#{sex},#{party},#{birthday},#{race},#{education},#{speciality},#{hobby},#{remark})")
	public int addEmployee(Employee e);
	
	@Delete("delete from employee_inf where id=#{id}")
	public int deleteEmployee(int id);
	
	@Select("select * from employee_inf where id=#{id}")
	public Employee selectEmployeeById(int id);
	
	//@UpdateProvider(method = "updateEmployee", type = EmployeeDaoPro.class)
	@Update("update employee_inf set dept_id=#{dept_id},job_id=#{job_id},name=#{name},card_id=#{card_id},address=#{address},post_code=#{post_code},tel=#{tel}" +
			",phone=#{phone},qq_num=#{qq_num},email=#{email},sex=#{sex},party=#{party},birthday=#{birthday},race=#{race},education=#{education},speciality=#{speciality},hobby=#{hobby},remark=#{remark} where id=#{id}")
	public int updateEmployee(Employee e);
}
