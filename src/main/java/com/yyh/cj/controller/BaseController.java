package com.yyh.cj.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BaseController {
	private static int counter = 0;
	private static final String VIEW_INDEX = "index";
	private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(BaseController.class);
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String welcome(ModelMap model){
		//System.out.println("==============welcome===============");
		model.addAttribute("message", "Welcome");
		model.addAttribute("counter", ++counter);
		Logger.debug("[welcome] counter:{}",counter);
		return VIEW_INDEX;
	}
	
	@RequestMapping(value="/{name}",method=RequestMethod.GET)
	public String welcomeName(@PathVariable String name,ModelMap model){//@PathVariable用来获取url中的动态参数
		//System.out.println("==============welcomename===============");
		model.addAttribute("message", "Welcome "+name);
		model.addAttribute("counter", ++counter);
		Logger.debug("[welcomeName] counter:{}",counter);
		return VIEW_INDEX;
	}
}
