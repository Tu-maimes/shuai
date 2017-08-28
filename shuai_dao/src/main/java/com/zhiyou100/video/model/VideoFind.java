package com.zhiyou100.video.model;


public class VideoFind {
		private Integer speaker;
		private Integer course;
		private String vodeoTitle;
		private Integer page;
		
	public Integer getSpeaker() {
			return speaker;
		}
		public void setSpeaker(Integer speaker) {
			this.speaker = speaker;
		}
		public Integer getCourse() {
			return course;
		}
		public void setCourse(Integer course) {
			this.course = course;
		}
		public String getVodeoTitle() {
			return vodeoTitle;
		}
		public void setVodeoTitle(String vodeoTitle) {
			this.vodeoTitle = vodeoTitle;
		}
		public Integer getPage() {
			return page;
		}
		public void setPage(Integer page) {
			this.page = page;
		}
		@Override
		public String toString() {
			return "VideoFind [speaker=" + speaker + ", course=" + course + ", vodeoTitle=" + vodeoTitle + ", page="
					+ page + "]";
		}
		
		
}
