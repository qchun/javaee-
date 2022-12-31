package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.bean.Dept;
import com.bean.Document;
import com.bean.Employee;
import com.bean.Job;
import com.bean.Notice;
import com.bean.User;
import com.manager.PageManager;
import com.service.DeptService;
import com.service.DocumentService;
import com.service.EmployeeService;
import com.service.JobService;
import com.service.NoticeService;
import com.service.UserService;

@Controller
public class DocumentController {
	@Resource(name="documentService")		//@Autowired×Ô¶¯Æ¥Åä
	DocumentService documentService;
	@Resource(name="userService")
	UserService userService;
	
	@RequestMapping("/selectDocument")
	public String selectDocument(Document d,Integer pageNow,Model m,HttpSession hs){
		if(pageNow==null) pageNow=1;
		int totalSize = documentService.selectDocumentCount(d);
		PageManager pm = new PageManager(pageNow,5,totalSize);
		Map map = new HashMap();
		map.put("document", d);
		map.put("pm", pm);
		List<Document> documentList=documentService.selectDocument(map);
		m.addAttribute("documentList", documentList);
		m.addAttribute("document", d);
		m.addAttribute("pm", pm);
		
		List<User> userList = userService.selectAllUser();
		hs.setAttribute("userList", userList);
		return "document/selectDocument";
	}
	
	@RequestMapping("/addDocumentView")
	public String addDocumentView(HttpSession hs){
		return "document/addDocumentView";
	}
	
	@RequestMapping("/addDocument")
	public String addDocument(Document d,Model m,HttpSession hs,MultipartFile file){
		String path = hs.getServletContext().getRealPath("files");
		String filename = file.getOriginalFilename();
		File newfile = new File(path,filename);
		d.setFilename(filename);
		User user = (User) hs.getAttribute("user");
		d.setUser_id(user.getId());
		int i=0;
		try {
			file.transferTo(newfile);
			i = documentService.addDocument(d);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			m.addAttribute("msg","Ìí¼ÓÊ§°Ü");
			return "fail";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			m.addAttribute("msg","Ìí¼ÓÊ§°Ü");
			return "fail";
		}
		if(i==1){
			return "redirect:selectDocument";
		}else{
			m.addAttribute("msg","Ìí¼ÓÊ§°Ü");
			return "fail";
		}
	}
	
	@RequestMapping("/deleteDocument")
	public String deleteDocument(int id,Model m,HttpSession hs){
		String path = hs.getServletContext().getRealPath("files");
		Document document = documentService.selectDocumentById(id);
		String filename = document.getFilename();
		File f = new File(path,filename);
		f.delete();
		//file.delete();
		int i = documentService.deleteDocument(id);
		if(i==1){
			return "redirect:selectDocument";
		}else{
			m.addAttribute("msg","É¾³ýÊ§°Ü");
			return "fail";
		}
	}
	
	@RequestMapping("/deleteDocuments")
	public String deleteDocuments(int[] ids){
		documentService.deleteDocuments(ids);
		return "redirect:selectDocument";
	}
	
	@RequestMapping("/updateDocumentView")
	public String updateDocumentView(int id,Model m){
		Document document = documentService.selectDocumentById(id);
		m.addAttribute("document", document);
		return "document/updateDocumentView";
	}
	
	@RequestMapping("/updateDocument")
	public String updateDocument(Document d,Model m,HttpSession hs,MultipartFile file,HttpServletRequest req){
		if(!file.isEmpty()){
			String path = hs.getServletContext().getRealPath("files");
			String filename = file.getOriginalFilename();
			String ff = req.getParameter("f");
			File fff = new File(path,ff);
			fff.delete();
			File newfile = new File(path,filename);
			d.setFilename(filename);
			try {
				file.transferTo(newfile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		User user = (User) hs.getAttribute("user");
		d.setUser_id(user.getId());
		int i = documentService.updateDocument(d);
		if(i==1){
			return "redirect:selectDocument";
		}else{
			m.addAttribute("msg","ÐÞ¸ÄÊ§°Ü");
			return "fail";
		}
	}
	
	@RequestMapping("/download")
	public ResponseEntity<byte[]> download(String filename,HttpServletRequest req) throws IOException{
		String path = req.getSession().getServletContext().getRealPath("files");
		filename = new String(filename.getBytes("iso-8859-1"),"utf-8");
		File file = new File(path,filename);
		HttpHeaders h = new HttpHeaders();
		h.setContentDispositionFormData("attachment",getFilename(req,filename));
		h.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),h,HttpStatus.OK);
	}
	
	public String getFilename(HttpServletRequest request,String filename) throws UnsupportedEncodingException{
		String[] IEBrowserKeyWords={"MSIE","Trident","Edge"};
		String userAgent=request.getHeader("User-Agent");
		for(String keyWord : IEBrowserKeyWords){
			if(userAgent.contains(keyWord)){
				return URLEncoder.encode(filename, "utf-8");
			}
		}
		return new String(filename.getBytes("UTF-8"),"ISO-8859-1");
		
	}

}
