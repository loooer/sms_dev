package com.yyh.cj.dao;

import java.util.List;

import com.yyh.cj.model.Users;

public interface UsersDao {
	List<Users> UsersQuery();
	boolean saveUser(Users user);
}
