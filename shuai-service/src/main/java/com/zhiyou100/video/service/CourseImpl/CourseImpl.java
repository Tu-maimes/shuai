package com.zhiyou100.video.service.CourseImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.CourseMapper;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.service.CourseService;
import com.zhiyou100.video.service.tools.Page;
@Service("Course")
public class CourseImpl implements CourseService {
	@Autowired
	CourseMapper cm;
	@Override
	public Page<Course> selectCourse(Integer page) {
		Page<Course> pa = new Page<>();
		pa.setPage(page);
		page = (page-1)*5;
		List<Course> list = cm.selectCourse(page);
		Integer count = cm.selectCoursecount();
		pa.setRows(list);
		pa.setSize(5);
		pa.setTotal(count);
		return pa;
	}
	@Override
	public Course selectIdcourse(Integer id) {
		
		
		return cm.selectByPrimaryKey(id);
	}
	@Override
	public void updateCourse(Course co) {
		cm.updateByPrimaryKeySelective(co);
	}
	@Override
	public void deleteIdcourse(Integer id) {
		cm.deleteByPrimaryKey(id);
	}
	@Override
	public void courseAdd(Course co) {
		cm.insertSelective(co);
	}
	@Override
	public List<Course> selectCourseName() {
		
		return cm.selectByExample(null);
	}
	

}