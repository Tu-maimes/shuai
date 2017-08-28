package com.zhiyou100.video.service;


import java.util.List;

import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.service.tools.Page;

public interface SpeakerService {
	Page<Speaker> selectSpeaker(String job,String name, Integer page);

	Speaker selectId(Integer id);

	void updateSpeaker(Speaker sk);

	void deleteId(Integer id);

	void addSpeaker(Speaker sk);

	List<Speaker> selectSpeakerName();
}
