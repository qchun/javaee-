package com.dao.pro;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.bean.User;
import com.manager.PageManager;

public class UserDaoPro {
	public String selectUser(final Map m){
		final User user = (User) m.get("user");
		final PageManager pm = (PageManager) m.get("pm");
		int pageNow = pm.getPageNow();
		int pageSize = pm.getPageSize();
		String sql = new SQL(){
			{
				SELECT("*");
				FROM("user_inf");
				if(user.getUsername()!=null){
					WHERE("username like concat('%',#{user.username},'%')");
				}
				if(user.getStatus()!=null){
					WHERE("status=#{user.status}");
				}
			}
		}.toString();
		sql=sql+" limit "+(pageNow-1)*pageSize+","+pageSize;
		return sql;
	}
	public String selectUserCount(final User u){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM("user_inf");
				if(u.getUsername()!=null){
					WHERE("username like concat('%',#{username},'%')");
				}
				if(u.getStatus()!=null){
					WHERE("status=#{status}");
				}
			}
		}.toString();
	}
}
