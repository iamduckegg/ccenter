package com.xljt.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/contract")
public class DownloadUtil {
	@RequestMapping("/download")
	public ResponseEntity<byte[]> export(String fileName,String filePath) throws IOException {  
		fileName = "车辆保险登记 (2019.3.25).xlsx";
		filePath= "C:/Users/ZX/Desktop/upload/";
        HttpHeaders headers = new HttpHeaders();    
        File file = new File(filePath+fileName);
        //下载显示的中文名，解决中文名称乱码问题
        fileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
        
        headers.setContentDispositionFormData("attachment", fileName);    
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);    
       
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);    
    }
}
