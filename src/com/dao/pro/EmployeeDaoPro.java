package com.dao.pro;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.bean.Employee;
import com.bean.User;
import com.manager.PageManager;

public class EmployeeDaoPro {
	public String selectEmployee(final Map m){
		final Employee employee = (Employee) m.get("employee");
		final PageManager pm = (PageManager) m.get("pm");
		int pageNow = pm.getPageNow();
		int pageSize = pm.getPageSize();
		String sql = new SQL(){
			{
				SELECT("*");
				FROM("employee_inf");
				if(employee.getJob_id()!=null){
					WHERE("job_id = #{employee.job_id}");
				}
				if(employee.getName()!=null){
					WHERE("name like concat('%',#{employee.name},'%')");
				}
				if(employee.getCard_id()!=null){
					WHERE("card_id like concat('%',#{employee.card_id},'%')");
				}
				if(employee.getSex()!=null){
					WHERE("sex = #{employee.sex}");
				}
				if(employee.getPhone()!=null){
					WHERE("phone like concat('%',#{employee.phone},'%')");
				}
				if(employee.getDept_id()!=null){
					WHERE("dept_id = #{employee.dept_id}");
				}
			}
		}.toString();
		sql=sql+" limit "+(pageNow-1)*pageSize+","+pageSize;
		return sql;
	}
	public String selectEmployeeCount(final Employee e){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM("employee_inf");
				if(e.getJob_id()!=null){
					WHERE("job_id = #{job_id}");
				}
				if(e.getName()!=null){
					WHERE("name like concat('%',#{name},'%')");
				}
				if(e.getCard_id()!=null){
					WHERE("card_id like concat('%',#{card_id},'%')");
				}
				if(e.getSex()!=null){
					WHERE("sex = #{sex}");
				}
				if(e.getPhone()!=null){
					WHERE("phone like concat('%',#{phone},'%')");
				}
				if(e.getDept_id()!=null){
					WHERE("dept_id = #{dept_id}");
				}
			}
		}.toString();
	}
	/*public String updateEmployee(final Employee e){
		return new SQL(){
			{
				UPDATE("employee_inf");
				if(e.getDept_id()!=null){
					SET("dept_id=#{dept_id}");
				}
				WHERE("id=#{id}");
			}
		}.toString();
	}*/
}
