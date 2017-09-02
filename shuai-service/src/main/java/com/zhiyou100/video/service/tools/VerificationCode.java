package com.zhiyou100.video.service.tools;

import java.util.Random;

public class VerificationCode {
	public static String VCode(String StringTable ,int VerificationCodeNumber){
		String base = "StringTable";     
	    Random random = new Random();     
	    StringBuffer sb = new StringBuffer();     
	    for (int i = 0; i <VerificationCodeNumber; i++) {     
	        int number = random.nextInt(base.length());     
	        sb.append(base.charAt(number));     
	    }  
	    String sd= sb.toString();
		return sd;
	}

}
