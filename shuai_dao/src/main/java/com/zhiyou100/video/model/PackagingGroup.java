package com.zhiyou100.video.model;

public class PackagingGroup {
	private Speaker sk;
	private String name;
	private String job;
	public Speaker getSk() {
		return sk;
	}
	public void setSk(Speaker sk) {
		this.sk = sk;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	@Override
	public String toString() {
		return "PackagingGroup [sk=" + sk + ", name=" + name + ", job=" + job + "]";
	}
	

	
	

}
