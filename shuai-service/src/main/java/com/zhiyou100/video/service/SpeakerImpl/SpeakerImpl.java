package com.zhiyou100.video.service.SpeakerImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.SpeakerMapper;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.service.SpeakerService;
import com.zhiyou100.video.service.tools.Page;
@Service("Speaker")
public class SpeakerImpl implements SpeakerService {
	@Autowired
	SpeakerMapper ss;
	@Override
	public Page<Speaker> selectSpeaker(String job,String name, Integer page) {
		Page<Speaker> page1 = new Page<>();
		page1.setPage(page);
		page=(page-1)*5;
		List<Speaker> list =ss.selectBySpeaker(job,name,page);
		Integer count = ss.selectBySpeakerCount(job,name);
		page1.setTotal(count);
		page1.setRows(list);
		page1.setSize(5);
		
		return page1;
	}
	@Override
	public Speaker selectId(Integer id) {
		
		return ss.selectByPrimaryKey(id);
	}
	@Override
	public void updateSpeaker(Speaker sk) {
		ss.updateByPrimaryKeySelective(sk);
	}
	@Override
	public void deleteId(Integer id) {
		ss.deleteByPrimaryKey(id);
	}
	@Override
	public void addSpeaker(Speaker sk) {
		ss.insertSelective(sk);
		
	}
	@Override
	public List<Speaker> selectSpeakerName() {
		
		return ss.selectByExample(null);
	}

}
