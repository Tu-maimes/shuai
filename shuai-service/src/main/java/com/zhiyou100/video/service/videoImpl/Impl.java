package com.zhiyou100.video.service.videoImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.VideoMapper;
import com.zhiyou100.video.model.Statistics;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.model.VideoAll;
import com.zhiyou100.video.model.VideoExample;
import com.zhiyou100.video.model.VideoFind;
import com.zhiyou100.video.service.VideoService;
import com.zhiyou100.video.service.tools.Page;
@Service
public class Impl implements VideoService {
	@Autowired
	VideoMapper vm;
	@Override
	public Page<VideoAll> selectvideo(VideoFind vf) {
	Page<VideoAll> page2 = new	Page<>();
	page2.setPage(vf.getPage());
	vf.setPage((vf.getPage()-1)*5);
	List<VideoAll> list = vm.selectVideo(vf);
	Integer count = vm.selectVideoCount(vf);
	page2.setRows(list);
	page2.setSize(5);
	page2.setTotal(count);
		return page2;
	}
	@Override
	public void deleteId(Integer id) {
		vm.deleteByPrimaryKey(id);
		
	}
	@Override
	public void addvideo(Video vd) {
		vm.insertSelective(vd);
		
	}
	@Override
	public Video updateVideo(Integer id) {
		return vm.selectByPrimaryKey(id);
	}
	@Override
	public void updateVideovd(Video vd) {
		vm.updateByPrimaryKeySelective(vd);
	}
	@Override
	public void addVideop(Video vd) {
		vm.insertSelective(vd);
	}
	@Override
	public void deletteAll(List<Integer> list) {
		VideoExample example = new VideoExample();
		example.createCriteria().andIdIn(list);
		vm.deleteByExample(example);
		
	}
	@Override
	public List<Statistics> selectStaistics() {
		
		return vm.selectStaistics();
	}
	

}
