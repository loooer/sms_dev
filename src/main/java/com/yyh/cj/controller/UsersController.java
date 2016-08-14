package com.yyh.cj.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yyh.cj.model.Users;
import com.yyh.cj.service.UsersService;

@Controller
public class UsersController {
	private UsersService usersService;
	
	public UsersService getUsersService() {
		return usersService;
	}
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}
	private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(UsersController.class);
	@RequestMapping(value="/users.do",method=RequestMethod.GET)
	public String QueryUsers(ModelMap model){
		System.out.println(usersService.UsersQuery().size());
		Users user = usersService.UsersQuery().get(0);
		Logger.info("name:"+user.getName()+" password:"+user.getPassword());
		model.addAttribute("name", user.getName());
		model.addAttribute("password", user.getPassword());
		return "users";
	}

	@RequestMapping(value="/allusers.do",method=RequestMethod.GET)
	public String getAllUsers(ModelMap model){
		List<Object> users = usersService.getAllUsers();
		Logger.info("users size:"+users.size());
		model.addAttribute("users", users);
		return "users";
	}

}
