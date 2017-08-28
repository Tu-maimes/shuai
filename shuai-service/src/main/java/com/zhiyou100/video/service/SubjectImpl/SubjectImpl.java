package com.zhiyou100.video.service.SubjectImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.SubjectMapper;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.service.SubjectService;
@Service("Subject")
public class SubjectImpl implements SubjectService {
	@Autowired
	SubjectMapper sm;
	@Override
	public List<Subject> selectSpeaker(Subject sj) {
		sm.selectByExample(null);
		return sm.selectByExample(null);
	}
	@Override
	public List<Subject> selectSubject() {
		return sm.selectByExample(null);
	}

}
