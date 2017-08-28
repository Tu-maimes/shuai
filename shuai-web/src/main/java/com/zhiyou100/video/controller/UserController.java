package com.zhiyou100.video.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.video.model.User;
import com.zhiyou100.video.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService us;
	public String selectUser(Model md){
		List<User> list = us.selectUser(null);
		
		md.addAttribute("list",list);
		
		
		return "user/userList";
		
	}
	

}
