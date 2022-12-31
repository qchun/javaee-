package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.bean.User;
import com.dao.pro.UserDaoPro;

@Repository("userDao")
public interface UserDao {
	@Select("select * from user_inf where loginname=#{loginname} and password=#{password}")
	public User login(User u);
	
	@SelectProvider(method = "selectUser", type = UserDaoPro.class)
	public List<User> selectUser(Map m);
	
	@SelectProvider(method = "selectUserCount", type = UserDaoPro.class)
	public int selectUserCount(User u);
	
	@Insert("insert into user_inf(loginname,password,status,username) value(#{loginname},#{password},#{status},#{username})")
	public int addUser(User u);
	
	@Delete("delete from user_inf where id=#{id}")
	public int deleteUser(int id);
	
	@Select("select * from user_inf where id=#{id}")
	public User selectUserById(int id);
	
	@Update("update user_inf set loginname=#{loginname},password=#{password},status=#{status},username=#{username} where id=#{id}")
	public int updateUser(User u);

	@Select("select * from user_inf")
	public List<User> selectAllUser();
}
