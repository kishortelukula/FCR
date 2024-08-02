package com.fcr.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Clob;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fcr.entity.FcrDocTag;
import com.fcr.repository.FcrDocTagRepo;

@Service
public class FcrDocTagService {

	private static final String UPLOAD_DIR = "C:\\Users\\Sreenivas Bandaru\\Desktop\\Gaini\\New folder";

	@Autowired
	private FcrDocTagRepo docTagRepo;

	public String saveFile(MultipartFile file) throws IOException {
		File dir = new File(UPLOAD_DIR);
		if (!dir.exists()) {
			dir.mkdirs();
		}

		File savedFile = new File(dir, file.getOriginalFilename());
		try (FileOutputStream fos = new FileOutputStream(savedFile)) {
			fos.write(file.getBytes());
		}

		return savedFile.getAbsolutePath();
	}

	public String convertFileToBase64Url(String filePath) throws IOException {
		File file = new File(filePath);
		byte[] fileContent = Files.readAllBytes(file.toPath());
		String base64String = Base64.getEncoder().encodeToString(fileContent);
		
		// Determine MIME type
        String mimeType = Files.probeContentType(file.toPath());
        if (mimeType == null) {
            mimeType = "application/octet-stream"; // Default MIME type
        }

		// Create a URL-like format for the Base64 string
		return "data:" + Files.probeContentType(file.toPath()) + ";base64," + base64String;
		
		
	}

	public void saveFileDetails(String fileName,String filePath) {
		FcrDocTag fileEntity = new FcrDocTag();
		fileEntity.setFileName(fileName);
		fileEntity.setFilePath(filePath);
		docTagRepo.save(fileEntity);
	}
}
