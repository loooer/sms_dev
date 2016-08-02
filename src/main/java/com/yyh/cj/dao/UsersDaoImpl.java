package com.yyh.cj.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.yyh.cj.model.Users;

public class UsersDaoImpl implements UsersDao{
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Users> UsersQuery() {
		List<Map<String, Object>> lists = getJdbcTemplate().queryForList("select * from users");
		List<Users> users = new ArrayList<Users>();
		if(lists != null && lists.size() > 0){
			for(Map<String, Object> list : lists){
				Users user = new Users();
				user.setUserId((Integer)list.get("userid"));
				user.setName((String)list.get("name"));
				user.setPassword((String)list.get("password"));
				users.add(user);
			}
		}
		return users;
	}

	@Override
	public boolean saveUser(Users user) {
		// TODO Auto-generated method stub
		return false;
	}

}
