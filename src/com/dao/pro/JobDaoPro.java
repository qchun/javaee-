package com.dao.pro;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.bean.Job;
import com.bean.User;
import com.manager.PageManager;

public class JobDaoPro {
	public String selectJob(final Map m){
		final Job job = (Job) m.get("job");
		final PageManager pm = (PageManager) m.get("pm");
		int pageNow = pm.getPageNow();
		int pageSize = pm.getPageSize();
		String sql = new SQL(){
			{
				SELECT("*");
				FROM("job_inf");
				if(job.getName()!=null){
					WHERE("name like concat('%',#{job.name},'%')");
				}
				if(job.getRemark()!=null){
					WHERE("remark like concat('%',#{job.remark},'%')");
				}
			}
		}.toString();
		sql=sql+" limit "+(pageNow-1)*pageSize+","+pageSize;
		return sql;
	}
	public String selectJobCount(final Job j){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM("job_inf");
				if(j.getName()!=null){
					WHERE("name like concat('%',#{name},'%')");
				}
				if(j.getRemark()!=null){
					WHERE("remark like concat('%',#{remark},'%')");
				}
			}
		}.toString();
	}
}
