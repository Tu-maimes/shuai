package com.zhiyou100.video.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.video.model.admin;
import com.zhiyou100.video.service.adminService;

@Controller
public class adController {
	
	@Autowired
	adminService as;
	@RequestMapping("admin/login.action")
	public String selectadmin(admin ad,Model md,HttpSession hs) throws Exception{
		String str = ad.getLoginPwd();
		 MessageDigest mdk=MessageDigest.getInstance("MD5");
		 mdk.update(str.getBytes());
		 String string = new BigInteger(1,mdk.digest()).toString(16);
		 ad.setLoginPwd(string);
        System.out.println(string);
		List<admin> list = as.selectadmin(ad);
		if(list.size()==0){
			md.addAttribute("error", "用户名或密码错误");
			return "forward:/login.jsp";
		}
		hs.setAttribute("admin",list.get(0));
		return "redirect:/video/videoList.action";
	}
	@RequestMapping("/admin/loginout.action")
	public String logout(HttpSession hs){
		hs.removeAttribute("admin");
		return "redirect:/login.jsp";
	}
	@RequestMapping("/adminMan/login.action")
	public String login(HttpSession admin){
		return "redirect:/login.jsp";
	}
}
