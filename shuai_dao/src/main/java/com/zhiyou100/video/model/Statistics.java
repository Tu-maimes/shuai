package com.zhiyou100.video.model;

public class Statistics {
	private Integer avg;
	private String courseName;
	public Integer getAvg() {
		return avg;
	}
	public void setAvg(Integer avg) {
		this.avg = avg;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	@Override
	public String toString() {
		return "Statistics [avg=" + avg + ", courseName=" + courseName + "]";
	}
	
	

}
