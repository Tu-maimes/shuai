package com.zhiyou100.video.service.CourseImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.CourseMapper;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.CourseExample;
import com.zhiyou100.video.model.CourseTow;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.CourseService;
import com.zhiyou100.video.service.tools.Page;
import com.zhiyou100.video.service.tools.VideoTime;
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
	@Override
	public List<Course> selectCs(int subjectId) {
		CourseExample example = new CourseExample();
		example.createCriteria().andSubjectIdEqualTo(subjectId);
		return cm.selectByExample(example);
	}
	@Override
	public List<CourseTow> selectVideoCourse(int subjectId) {
		List<CourseTow> list = cm.selectVideoCourse(subjectId);
		for (CourseTow li : list) {
			List<Video> video= li.getVideoList();
			for (Video vi : video) {
				vi.setVideoLengthStr(VideoTime.send(vi.getVideoLength()));
			}
		}
		
		return list;
	}
	

}
