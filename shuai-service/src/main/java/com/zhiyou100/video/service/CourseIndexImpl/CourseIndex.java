package com.zhiyou100.video.service.CourseIndexImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.SubjectMapper;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.service.CourseIndexService;
@Service
public class CourseIndex implements CourseIndexService {
	@Autowired
	SubjectMapper sm;
	@Override
	public Subject selectCourse(int subjectId) {
		return sm.selectByPrimaryKey(subjectId);
	}
	

}
