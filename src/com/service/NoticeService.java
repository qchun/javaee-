package com.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Employee;
import com.bean.Notice;
import com.bean.User;
import com.dao.EmployeeDao;
import com.dao.NoticeDao;
import com.dao.UserDao;

@Service("noticeService")
public class NoticeService {
	@Resource(name="noticeDao")		//@Autowired
	NoticeDao noticedao;
	
	
	public List<Notice> selectNotice(Map m){
		return noticedao.selectNotice(m);
	}
	
	public int selectNoticeCount(Notice n){
		return noticedao.selectNoticeCount(n);
	}
	
	public int addNotice(Notice n){
		return noticedao.addNotice(n);
	}
	
	public int deleteNotice(int id){
		return noticedao.deleteNotice(id);
	}
	
	public void deleteNotices(int[] ids){
		for(int i=0;i<ids.length;i++){
			noticedao.deleteNotice(ids[i]);
		}
	}
	
	public Notice selectNoticeById(int id){
		return noticedao.selectNoticeById(id);
	}
	
	public int updateNotice(Notice n){
		return noticedao.updateNotice(n);
	}
}
