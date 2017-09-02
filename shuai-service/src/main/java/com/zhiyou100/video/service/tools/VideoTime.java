package com.zhiyou100.video.service.tools;

public class VideoTime {
	public static String send(Integer time){
		
		Integer hours = time/3600; 
		Integer minutes = time%3600/60;
		Integer seconds = time%60;
		return String.format("%02d : %02d :%02d",hours,minutes,seconds);
//		if(time==null){
//			return "00:00:00";
//		}
//		int a = time;
//		int b = a/3600;
//		String Str = null;
//		if(b<10){
//			 Str= "0"+b;
//		}else{
//			 Str = ""+b;
//		} 
//		Str = Str+":";
//		int c= (a%3600)/60;
//		if(c<10){
//			Str = Str+"0"+c;
//		}else{
//			Str=Str+c;
//		}
//		int d = (a%60);
//		Str = Str+":";
//		if(d<10){
//			Str = Str+"0"+d;
//		}else{
//			Str = Str+d;
//		}
		
	}
}
