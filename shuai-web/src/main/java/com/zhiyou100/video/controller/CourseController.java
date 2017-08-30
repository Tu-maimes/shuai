package com.zhiyou100.video.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.service.CourseService;
import com.zhiyou100.video.service.SubjectService;
import com.zhiyou100.video.service.tools.Page;

@Controller
@RequestMapping("/course")
public class CourseController {
	@Autowired
	CourseService cs;
	@Resource(name ="Subject")
	SubjectService ss;
	@RequestMapping("/courseList.action")
		public String selectCourse(@RequestParam(defaultValue ="1")Integer page,Model md){
			Page<Course> list = cs.selectCourse(page);
			md.addAttribute("page",list);
			
			return "course/courseList";
			
		}
	@RequestMapping("/{id}.action")
	public String selectById(@PathVariable Integer id,Model md){
		Course sk = cs.selectIdcourse(id);
		List<Subject> list =ss.selectSubject();
		md.addAttribute("list",sk);
		md.addAttribute("subject", list);
		return "course/coursemanage";
		
	}
	@RequestMapping("/delete/delete.action")
	@ResponseBody
	public String deleteById( Integer id){
		 cs.deleteIdcourse(id);
		
		return "success";
		
	}
	@RequestMapping("/coursemanage.action")
	public String updateCourse(Course co){
		cs.updateCourse(co);
		return "redirect:/course/courseList.action";
	}
	@RequestMapping("/course.action")
	public String Coursea(Course co,Model md){
		List<Subject> list =ss.selectSubject();
		md.addAttribute("subject", list);
		return "/course/courseAdd";
	}
	@RequestMapping("/courseAdd.action")
	public String courseAdd(Course co){
		cs.courseAdd(co);
		return "redirect:/course/courseList.action";
	}
		
		
}

