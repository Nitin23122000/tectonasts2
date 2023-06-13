package com.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate jdbctemplate;
	
	public  int insertUser(User u) {
		int update = jdbctemplate.update("insert into tectona(id,name,email,city) values(?,?,?,?)",u.getId(),u.getName(),u.getEmail(),u.getCity());
		return update;
	}
	
	public List<User> getAllUser(){
		List<User> data = jdbctemplate.query("select * from tectona",new BeanPropertyRowMapper<User>(User.class));
		return data;
	}
	
	public  User getById(int id) {
		User u=null;
		
		try {
			u = jdbctemplate.queryForObject("select * from tectona where id=?",new Object[] {id},new BeanPropertyRowMapper<User>(User.class) );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public int updateUser(User u) {
		int data = jdbctemplate.update("update tectona set name=?,email=?,city=? where id=?",u.getName(),u.getEmail(),u.getCity(),u.getId());
		return data;
	}
	
	public boolean deleteUser(int id) {
		int result = jdbctemplate.update("delete from tectona where id=?",id);
		if(result==0) {
			return false;
		}
		else {
			return true;
		}
	}
}
