package com.bean;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class Employee {
	Integer id;
	Integer dept_id;
	Integer job_id;
	String name;
	String card_id;
	String address;
	String post_code;
	String tel;
	String phone;
	String qq_num;
	String email;
	Integer sex;
	String party;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date birthday;
	String race;
	String education;
	String speciality;
	String hobby;
	String remark;
	Date create_date;
	Dept dept;
	Job job;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDept_id() {
		return dept_id;
	}
	public void setDept_id(Integer deptId) {
		dept_id = deptId;
	}
	public Integer getJob_id() {
		return job_id;
	}
	public void setJob_id(Integer jobId) {
		job_id = jobId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String cardId) {
		card_id = cardId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPost_code() {
		return post_code;
	}
	public void setPost_code(String postCode) {
		post_code = postCode;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQq_num() {
		return qq_num;
	}
	public void setQq_num(String qqNum) {
		qq_num = qqNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date createDate) {
		create_date = createDate;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
}
