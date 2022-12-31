package com.dao.pro;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.bean.Dept;
import com.bean.User;
import com.manager.PageManager;

public class DeptDaoPro {
	public String selectDept(final Map m){
		final Dept dept = (Dept) m.get("dept");
		final PageManager pm = (PageManager) m.get("pm");
		int pageNow = pm.getPageNow();
		int pageSize = pm.getPageSize();
		String sql = new SQL(){
			{
				SELECT("*");
				FROM("dept_inf");
				if(dept.getName()!=null){
					WHERE("name like concat('%',#{dept.name},'%')");
				}
				if(dept.getRemark()!=null){
					WHERE("remark like concat('%',#{dept.remark},'%')");
				}
			}
		}.toString();
		sql=sql+" limit "+(pageNow-1)*pageSize+","+pageSize;
		return sql;
	}
	public String selectDeptCount(final Dept d){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM("dept_inf");
				if(d.getName()!=null){
					WHERE("name like concat('%',#{name},'%')");
				}
				if(d.getRemark()!=null){
					WHERE("remark like concat('%',#{remark},'%')");
				}
			}
		}.toString();
	}
}
