package com.jdbc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class fileUploader {

	public final String UPLOAD_DIR=new ClassPathResource("/static/images/").getFile().getAbsolutePath();

	public fileUploader() throws IOException{
		
	}
	
	public boolean uploadfile(MultipartFile multipart) {
		boolean f=false;
		
		try {
			Files.copy(multipart.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipart.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
			
			f=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	
}
