package com.zhiyou100.video.service;


import java.util.List;

import com.zhiyou100.video.model.Statistics;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.model.VideoAll;
import com.zhiyou100.video.model.VideoFind;
import com.zhiyou100.video.service.tools.Page;

public interface VideoService {

	Page<VideoAll> selectvideo(VideoFind vf);

	void deleteId(Integer id);

	void addvideo(Video vd);

	Video updateVideo(Integer id);

	void updateVideovd(Video vd);

	void addVideop(Video vd);

	void deletteAll(List<Integer> list);

	List<Statistics> selectStaistics();

}
