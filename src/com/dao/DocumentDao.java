package com.dao;

import java.util.List;

import java.util.Map;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import com.bean.Document;
import com.bean.Employee;
import com.bean.Notice;
import com.dao.pro.DocumentDaoPro;
import com.dao.pro.EmployeeDaoPro;
import com.dao.pro.NoticeDaoPro;

@Repository("documentDao")
public interface DocumentDao {
	
	@SelectProvider(method = "selectDocument", type = DocumentDaoPro.class)
	@Results({
		@Result(property="user",column="user_id",one=@One(select="com.dao.UserDao.selectUserById",fetchType=FetchType.LAZY))
	})
	public List<Document> selectDocument(Map m);
	
	@SelectProvider(method = "selectDocumentCount", type = DocumentDaoPro.class)
	public int selectDocumentCount(Document d);
	
	@Insert("insert into document_inf(title,filename,remark,user_id) value(#{title},#{filename},#{remark},#{user_id})")
	public int addDocument(Document d);
	
	@Delete("delete from document_inf where id=#{id}")
	public int deleteDocument(int id);
	
	@Select("select * from document_inf where id=#{id}")
	public Document selectDocumentById(int id);
	
	//@Update("update document_inf set title=#{title},filename=#{filename},remark=#{remark},user_id=#{user_id} where id=#{id}")
	@UpdateProvider(method = "updateDocument", type = DocumentDaoPro.class)
	public int updateDocument(Document d);
}
