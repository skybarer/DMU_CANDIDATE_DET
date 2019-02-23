package com.hcl.dmu.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class BatchUtils {

	@Value("${batchProfilePath}")
	private String batchProfilePath;
	
	private static final Logger LOG = LoggerFactory.getLogger(BatchUtils.class);
	
	
	public String getUploadedFilePath(String name, MultipartFile file) {
		StringBuilder sb = new StringBuilder();
		String originalFilename = file.getOriginalFilename();
		if(originalFilename.lastIndexOf(".") !=-1){
			sb.append(name).append("_").append(System.currentTimeMillis());
			sb.append(originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length()));	
		}else{
			sb.append(name).append(originalFilename).append(".csv");
		}
		try {
			byte[] bytes = file.getBytes();
			System.out.println(file.getSize());
			String fullPath = batchProfilePath.concat(sb.toString());
			Path path = Paths.get(fullPath);
            Files.write(path, bytes);
            return sb.toString();
		}catch (IOException e) {
			
			LOG.error(e.getMessage());
			
			return "";
		}
	}
}
