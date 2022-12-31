package com.dao;

import java.util.List;

import java.util.Map;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;
import com.bean.Employee;
import com.bean.Notice;
import com.dao.pro.EmployeeDaoPro;
import com.dao.pro.NoticeDaoPro;

@Repository("noticeDao")
public interface NoticeDao {
	
	@SelectProvider(method = "selectNotice", type = NoticeDaoPro.class)
	@Results({
		@Result(property="user",column="user_id",one=@One(select="com.dao.UserDao.selectUserById",fetchType=FetchType.LAZY))
	})
	public List<Notice> selectNotice(Map m);
	
	@SelectProvider(method = "selectNoticeCount", type = NoticeDaoPro.class)
	public int selectNoticeCount(Notice n);
	
	@Insert("insert into notice_inf(title,content,user_id) value(#{title},#{content},#{user_id})")
	public int addNotice(Notice n);
	
	@Delete("delete from notice_inf where id=#{id}")
	public int deleteNotice(int id);
	
	@Select("select * from notice_inf where id=#{id}")
	public Notice selectNoticeById(int id);
	
	@Update("update notice_inf set title=#{title},content=#{content},user_id=#{user_id} where id=#{id}")
	public int updateNotice(Notice n);
}
