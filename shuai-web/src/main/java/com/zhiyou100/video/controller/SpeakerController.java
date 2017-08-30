package com.zhiyou100.video.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.service.SpeakerService;
import com.zhiyou100.video.service.tools.Page;
@Controller
@RequestMapping("/speaker")
public class SpeakerController {
	@Autowired
	SpeakerService ss;
	@RequestMapping(value ="/speakerList.action",method=RequestMethod.GET)
	public String selectSpeaker(
			@RequestParam(defaultValue ="")String job,
			@RequestParam(defaultValue ="")String name,
			@RequestParam(defaultValue ="1")Integer page,
			Model md){
	Page<Speaker> list = ss.selectSpeaker(job,name,page);
	md.addAttribute("page",list);
	md.addAttribute("name",name);
	md.addAttribute("job",job);
	
	return "speaker/speakerList";
	}
	@RequestMapping("/{id}.action")
	public String selectById(@PathVariable Integer id,Model md){
		Speaker sk = ss.selectId(id);
		md.addAttribute("list",sk);
		return "speaker/speakermanage";
		
	}
	@RequestMapping("/speakerUpdate.action")
	public String updateId(Speaker sk){
		ss.updateSpeaker(sk);
		return "redirect:/speaker/speakerList.action";
		
	}
	@RequestMapping("/delete/delete.action")
	@ResponseBody
	public String deleteId( Integer id){
		ss.deleteId(id);
		return "success";
		
	}
	@RequestMapping("/speakeradd.action")
	public String addSpeaker(Speaker sk){
		ss.addSpeaker(sk);
		return "redirect:/speaker/speakerList.action";
		
	}
	@RequestMapping("/speakerAdd.action")
	public String addSker(){
		return "/speaker/speakerAdd";
		
	}
	
}
