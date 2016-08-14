package com.yyh.cj.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.yyh.cj.dao.UsersDao;
import com.yyh.cj.model.Users;

@Transactional
public class UsersServiceImpl implements UsersService{
	private UsersDao usersDao;
	
	public UsersDao getUsersDao() {
		return usersDao;
	}

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	@Override
	public List<Users> UsersQuery() {
		return usersDao.UsersQuery();
	}

	@Override
	public List<Object> getAllUsers() {
		return usersDao.getAllUsers();
	}
}
