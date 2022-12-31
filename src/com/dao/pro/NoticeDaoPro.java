package com.dao.pro;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.bean.Employee;
import com.bean.Notice;
import com.bean.User;
import com.manager.PageManager;

public class NoticeDaoPro {
	public String selectNotice(final Map m){
		final Notice notice = (Notice) m.get("notice");
		final PageManager pm = (PageManager) m.get("pm");
		int pageNow = pm.getPageNow();
		int pageSize = pm.getPageSize();
		String sql = new SQL(){
			{
				SELECT("*");
				FROM("notice_inf");
				if(notice.getTitle()!=null){
					WHERE("title like concat('%',#{notice.title},'%')");
				}
				if(notice.getContent()!=null){
					WHERE("content like concat('%',#{notice.content},'%')");
				}
				if(notice.getUser_id()!=null){
					WHERE("user_id = #{notice.user_id}");
				}
			}
		}.toString();
		sql=sql+" limit "+(pageNow-1)*pageSize+","+pageSize;
		return sql;
	}
	public String selectNoticeCount(final Notice n){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM("notice_inf");
				if(n.getTitle()!=null){
					WHERE("title like concat('%',#{title},'%')");
				}
				if(n.getContent()!=null){
					WHERE("content like concat('%',#{content},'%')");
				}
				if(n.getUser_id()!=null){
					WHERE("user_id = #{user_id}");
				}
			}
		}.toString();
	}
}
