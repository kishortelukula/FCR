package com.fcr.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class FileUpload {
	private final Path rootLocation = Paths.get("uploads");

    public void init() {
        try {
            Files.createDirectory(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize upload directory");
        }
    }

    public void store(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new RuntimeException("Failed to store empty file.");
            }
            Path destinationFile = this.rootLocation.resolve(Paths.get(file.getOriginalFilename()))
                    .normalize().toAbsolutePath();
            if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
                // This is a security check 
                throw new RuntimeException("Cannot store file outside current directory.");
            }
            try (var inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file.", e);
        }
    }

}
