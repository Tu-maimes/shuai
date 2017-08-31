package com.zhiyou100.video.service.tools;

public class VideoTime {
	public static String send(int time){
		int a = time;
		int b = a/3600;
		String Str = null;
		if(b<10){
			 Str= "0"+b;
		}else{
			 Str = ""+b;
		} 
		Str = Str+":";
		int c= (a%3600)/60;
		if(c<10){
			Str = Str+"0"+c;
		}else{
			Str=Str+c;
		}
		int d = (a%60);
		Str = Str+":";
		if(d<10){
			Str = Str+"0"+d;
		}else{
			Str = Str+d;
		}
		return Str;
	}
}
