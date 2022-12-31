package com.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Document;
import com.bean.Employee;
import com.bean.Notice;
import com.bean.User;
import com.dao.DocumentDao;
import com.dao.EmployeeDao;
import com.dao.NoticeDao;
import com.dao.UserDao;

@Service("documentService")
public class DocumentService {
	@Resource(name="documentDao")		//@Autowired
	DocumentDao documentdao;
	
	
	public List<Document> selectDocument(Map m){
		return documentdao.selectDocument(m);
	}
	
	public int selectDocumentCount(Document d){
		return documentdao.selectDocumentCount(d);
	}
	
	public int addDocument(Document d){
		return documentdao.addDocument(d);
	}
	
	public int deleteDocument(int id){
		return documentdao.deleteDocument(id);
	}
	
	public void deleteDocuments(int[] ids){
		for(int i=0;i<ids.length;i++){
			documentdao.deleteDocument(ids[i]);
		}
	}
	
	public Document selectDocumentById(int id){
		return documentdao.selectDocumentById(id);
	}
	
	public int updateDocument(Document d){
		return documentdao.updateDocument(d);
	}
}
