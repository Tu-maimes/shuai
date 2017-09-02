package com.zhiyou100.video.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou100.video.model.Merchant;
import com.zhiyou100.video.service.MerchantService;
import com.zhiyou100.video.web.tools.ImageUpload;

@Controller
public class Merchantl {
	@Autowired
	MerchantService ms;
	@RequestMapping(value="merchant/merchant.do",method=RequestMethod.POST)
	public String selectMerchant(Merchant mer,Model md){
		mer.setUpdatetime(new Date());
		ms.inMerchant(mer);
		List<Merchant> li  =ms.selectMerchant(mer);
		md.addAttribute("md", li.get(0));
		return "/merchant/merchant";
	}
	@RequestMapping(value="merchant/logo.do",method=RequestMethod.GET)
	public String Merchant(Merchant mer,Model md){
		mer.setId(1);
		Merchant list=ms.selectMc(mer);
		md.addAttribute("md", list);
		return "/merchant/merchant";
	}
	@RequestMapping(value="merchant/license.do",method=RequestMethod.POST)
	public String Merchant(@RequestParam MultipartFile imgpic,Merchant mer) throws Exception{
		mer.setPic(ImageUpload.giveName(imgpic));
		ms.inMerchant(mer);
		return "redirect:/merchant/logo.do";
	}
	
}
