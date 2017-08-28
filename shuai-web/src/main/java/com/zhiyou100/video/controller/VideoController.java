package com.zhiyou100.video.controller;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.model.VideoAll;
import com.zhiyou100.video.model.VideoFind;
import com.zhiyou100.video.service.CourseService;
import com.zhiyou100.video.service.SpeakerService;
import com.zhiyou100.video.service.VideoService;
import com.zhiyou100.video.service.tools.Page;
@Controller
@RequestMapping("/video")
public class VideoController {
	@Autowired
	VideoService vs;
	@Resource(name="Course")
	CourseService cs;
	@Resource(name ="Speaker")
	SpeakerService ss;
	@RequestMapping("/videoList.action")
		public String selectVideo(Model md,VideoFind vf,
				@RequestParam(defaultValue="")String vodeoTitle,
				@RequestParam(defaultValue="1")Integer page,
				@RequestParam(defaultValue="0")Integer speaker,
				@RequestParam(defaultValue="0")Integer course
				){
		vf.setVodeoTitle(vodeoTitle);
		vf.setPage(page);
		vf.setSpeaker(speaker);
		vf.setCourse(course);
		Page<VideoAll>	list = vs.selectvideo(vf);
		List<Course> course1 = cs.selectCourseName();
		List<Speaker> speaker1 = ss.selectSpeakerName();
			md.addAttribute("page",list);
			md.addAttribute("course1", course1);
			md.addAttribute("speaker1", speaker1);
			md.addAttribute("course2", course);
			md.addAttribute("speaker2", speaker);
			md.addAttribute("vodeotitle1", vodeoTitle);
			
			return "/video/videoList";
		}
	
			@RequestMapping("/delete/{id}.action")
			public String deleteId(@PathVariable Integer id){
				vs.deleteId(id);
				return "redirect:/video/videoList.action";
				
			}
			
			@RequestMapping("/videoadd.action")
			public String addVideoSelect(Model md){
				List<Course> course1 = cs.selectCourseName();
				List<Speaker> speaker1 = ss.selectSpeakerName();
				md.addAttribute("course1", course1);
				md.addAttribute("speaker1", speaker1);
				return "/video/videoAdd";
			}
			@RequestMapping("/addVideo.action")
			public String addVideo(Video vd){
				vs.addVideop(vd);
				return "redirect:/video/videoList.action";
			}
			
			
			@RequestMapping("/{id}.action")
			public String updateVideo(@PathVariable Integer id,Model md){
			Video vi = vs.updateVideo(id);
			List<Course> course1 = cs.selectCourseName();
			List<Speaker> speaker1 = ss.selectSpeakerName();
			md.addAttribute("course1", course1);
			md.addAttribute("speaker1", speaker1);
			md.addAttribute("video",vi);
				return "/video/videomanage";
			}
			@RequestMapping("/videomanage.action")
			public String updateVideovd(Video vd){
				vs.updateVideovd(vd);
				
				return "redirect:/video/videoList.action";
				
			}
			@RequestMapping("/deleteAll.action")
			public String deleteAll(Integer [] thecheckbox){
				List<Integer> list = Arrays.asList(thecheckbox);
				vs.deletteAll(list);
				return "redirect:/video/videoList.action";
				
			}
	
}
