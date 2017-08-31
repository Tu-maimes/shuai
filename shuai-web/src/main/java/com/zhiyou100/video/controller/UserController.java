package com.zhiyou100.video.controller;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou100.video.model.User;
import com.zhiyou100.video.service.UserService;

/**   
*    
* 项目名称：shuai-web   
* 类名称：UserController   
* 类描述：   前台用户web
* 创建时间：2017年8月30日 下午9:32:22   
* 修改人：汪帅   
* 修改时间：2017年8月30日 下午9:32:22   
* 修改备注：   
* @version    
*    
*/
@Controller
public class UserController {
	@Autowired
	UserService us;
	/*主页面*/
	@RequestMapping(value="front/user.do",method=RequestMethod.GET)
	public String selectUser(){
		
		return "/front/index";
	}
	/*退出*/
	@RequestMapping(value="front/user/logout.do",method=RequestMethod.GET)
	public String logout(HttpSession hs){
		hs.invalidate();
		return "redirect:/front/user.do";
	}
	/*忘记密码*/
	
	@RequestMapping(value="front/user/forgetpwd.do",method=RequestMethod.GET)
	public String forgetpwd(){
		
		return "/front/user/forget_pwd";
	}
	/*注册请求处理*/
	@RequestMapping(value="/front/user/regist.do",method=RequestMethod.POST)
	@ResponseBody
	public String addUser(String email,String password,User user) throws Exception{
		/*MessageDigest mdk=MessageDigest.getInstance("MD5");
		 mdk.update(password.getBytes());
		 String string = new BigInteger(1,mdk.digest()).toString(16);*/
		user.setEmail(email);
		user.setPassword(password);
		us.addUser(user);
		return "success";
		
	}
	/*登录请求处理*/
	@RequestMapping(value="front/user/logink.do",method=RequestMethod.POST)
	@ResponseBody
	public String selectUser(String email,String password,User user,HttpSession hs){
		user.setEmail(email);
		user.setPassword(password);
		List<User> list = us.selectUser(user);
		if(list.size()==0){
			return "error";
		}
		User us=list.get(0);
		hs.setAttribute("_front_user",us);
		return "success";
		
	}
	/*更改头像*/
	@RequestMapping(value="front/user/avatar/{id}.do",method=RequestMethod.GET)
	public String avatar(@PathVariable Integer id, Model md){
		
		User user = us.selectUserIndex(id);
		md.addAttribute("user", user);
		return "/front/user/avatar";
	}
	/*我的资料*/
	@RequestMapping(value="front/user/index/{id}.do",method=RequestMethod.GET)
	public String userIndex(@PathVariable Integer id, Model md){
		User user = us.selectUserIndex(id);
		md.addAttribute("user", user);
		return "/front/user/index";
	}
	/*更改用户资料*/
	@RequestMapping(value="front/user/profile/{id}.do",method=RequestMethod.GET)
	public String profile(@PathVariable Integer id, Model md){
		
		User user = us.selectUserIndex(id);
		md.addAttribute("user", user);
		return "/front/user/profile";
	}
	/*更改密码*/
	@RequestMapping(value="front/user/password/{id}.do",method=RequestMethod.GET)
	public String password(@PathVariable Integer id, Model md){
		
		User user = us.selectUserIndex(id);
		md.addAttribute("user", user);
		return "/front/user/password";
	}
	/*修改密码*/
	@RequestMapping(value="front/user/topassword/.do",method=RequestMethod.POST)
	@ResponseBody
	public String toword(String oldPassword,String newPasswordAgain,
			HttpSession hs,User pe){
		User obj = (User)hs.getAttribute("_front_user");
		pe.setPassword(oldPassword);
		pe.setId(obj.getId());
		List<User> list = us.selectUsertoword(pe);
		if(list.size()==0){
			return "error";
		}
			pe.setPassword(newPasswordAgain);
			pe.setUpdateTime(new Date(System.currentTimeMillis()));
			us.updateProfile(pe);
			hs.invalidate();
		return "success";
	}
	/*@RequestMapping("front/user/password/.do")
	public String word(String newPasswordAgain,String oldPassword,HttpSession hs,
			Model md,User use){
		
		
		
		
//		use.setPassword(newPasswordAgain);
//		use.setUpdateTime(new Date(System.currentTimeMillis()));
//		 us.userUpdate(use);
//		 User user = us.selectUserIndex(use.getId());
//		md.addAttribute("user", user);
		return "/front/user/index";
	}*/
	/*保存用户修改信息*/
	@RequestMapping(value="front/user/profile.do",method=RequestMethod.POST)
	public String profile(User user,Model md){
		user.setInsertTime(new Date(System.currentTimeMillis()));
		us.updateProfile(user);
		
		User use = us.selectUserIndex(user.getId());
		md.addAttribute("user", use);
		return "/front/user/index";
	}
	/*上传头像*/
	@RequestMapping(value="front/user/avatar.do",method=RequestMethod.POST)
	public String updatatouser(User user,MultipartFile image_file,HttpSession hs) throws  IOException{
		String str = UUID.randomUUID().toString().replaceAll("-","");
		String ext = FilenameUtils.getExtension(image_file.getOriginalFilename());
		if(ext != "")
		{
		String fileName =str+"."+ext;
		String path ="E:\\unload";
		image_file.transferTo(new File(path+"\\"+fileName));
		user.setHeadUrl(fileName);
		}
		us.updatHeadUrl(user);
		User use = us.selectUserIndex(user.getId());
		hs.setAttribute("_front_user",use);
		return "/front/user/avatar";
	}
	/*发送验证码*/
	@RequestMapping(value="sendemail.do",method=RequestMethod.POST)
	@ResponseBody
	public String sendemail(User user,Model md) throws Exception{
//		String base = "abcdefghijklmnopqrstuvwxyz";     
//	    Random random = new Random();     
//	    StringBuffer sb = new StringBuffer();     
//	    for (int i = 0; i <4; i++) {     
//	        int number = random.nextInt(base.length());     
//	        sb.append(base.charAt(number));     
//	    }  
//	    String sd= sb.toString();
//	    MailUtil.send("1585019349@qq.com", "验证码",sd);
//	    user.setCaptcha(sd);
		
	    us.sendemail(user);
		return "success";
	}
	/*判断验证码是否正确*/
	@RequestMapping(value="front/user/forgetpwd.do",method=RequestMethod.POST)
	@ResponseBody
	public String forgetpwd(User user,HttpSession hs){
		List<User> list = us.forgetpwd(user);
		if(list.size()==0){
			return "error";
		}
		hs.setAttribute("userppp",list.get(0));
		return "success";
	}
	/*跳转重置密码jsp*/
	@RequestMapping(value="front/user/forget.do",method=RequestMethod.GET)
	public String forget(){
		return "/front/user/reset_pwd";
	}
	/*重置密码*/
	@RequestMapping(value="front/user/resetpwd.do",method=RequestMethod.POST)
	public String resetpwd(User user){
		user.setCaptcha("");
		us.updateRestPwd(user);
		return "redirect:/front/user/logout.do";
	}

}
