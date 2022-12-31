package com.dao.pro;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.bean.Document;
import com.bean.Employee;
import com.bean.Notice;
import com.bean.User;
import com.manager.PageManager;

public class DocumentDaoPro {
	public String selectDocument(final Map m){
		final Document document = (Document) m.get("document");
		final PageManager pm = (PageManager) m.get("pm");
		int pageNow = pm.getPageNow();
		int pageSize = pm.getPageSize();
		String sql = new SQL(){
			{
				SELECT("*");
				FROM("document_inf");
				if(document.getTitle()!=null){
					WHERE("title like concat('%',#{document.title},'%')");
				}
				if(document.getFilename()!=null){
					WHERE("filename like concat('%',#{document.filename},'%')");
				}
				if(document.getUser_id()!=null){
					WHERE("user_id = #{document.user_id}");
				}
			}
		}.toString();
		sql=sql+" limit "+(pageNow-1)*pageSize+","+pageSize;
		return sql;
	}
	public String selectDocumentCount(final Document d){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM("document_inf");
				if(d.getTitle()!=null){
					WHERE("title like concat('%',#{title},'%')");
				}
				if(d.getFilename()!=null){
					WHERE("filename like concat('%',#{filename},'%')");
				}
				if(d.getUser_id()!=null){
					WHERE("user_id = #{user_id}");
				}
			}
		}.toString();
	}
	public String updateDocument(final Document d){
		return new SQL(){
			{
				UPDATE("document_inf");
				if(d.getTitle()!=null){
					SET("title=#{title}");
				}
				if(d.getFilename()!=null){
					SET("filename=#{filename}");
				}
				if(d.getRemark()!=null){
					SET("remark=#{remark}");
				}
				WHERE("id=#{id}");
			}
		}.toString();
	}
}
