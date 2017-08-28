package com.zhiyou100.video.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.video.model.Statistics;
import com.zhiyou100.video.service.VideoService;
@Controller
public class StatisticsController {
	@Autowired
	VideoService   vs;
	@RequestMapping("/statistics.action")
	public String selectStaistics(Model md){
		List<Statistics> list =vs.selectStaistics();
		StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		for(int a =0;a<list.size();a++){
			buffer.append(list.get(a).getAvg());
			if(a<list.size()-1){
			buffer.append(",");
			}
		}
		buffer.append("]");
		StringBuffer bu = new StringBuffer();
		bu.append("[");
		int a = 0;
		for (Statistics pe : list) {
			bu.append('"');
			bu.append(pe.getCourseName());
			bu.append('"');
			if( a<list.size()-1){
				bu.append(",");
				}
		}
		
		bu.append("]");
		md.addAttribute("name",bu);
		md.addAttribute("count",buffer);
		
		return "statistics/Statistics";
		
	}

}
