package com.zhiyou100.video.web.tools;

import java.io.File;
import java.util.UUID;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;
public class ImageUpload {
	
	public static String  giveName(MultipartFile image_file) throws Exception{
		
		
		String str = UUID.randomUUID().toString().replaceAll("-","");
		String ext = FilenameUtils.getExtension(image_file.getOriginalFilename());
		String fileName=null;
		if(ext != "")
		{
			fileName =str+"."+ext;
			/*磁盘路径*/
		String path ="E:\\unload";
		image_file.transferTo(new File(path+"\\"+fileName));
		}
		/*数据库存储路径*/
		fileName = "/ppt/" +fileName;
		return fileName;

	}
	

}
