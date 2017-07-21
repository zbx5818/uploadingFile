package com.example.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
	private static final Path fileLocation = Paths.get("demo");

	public void storeFile(MultipartFile file) {
		System.out.println("location: " + fileLocation.toString());
		try {
			if (file.isEmpty()) {
				throw new IllegalStateException("Illegal File Name");
			}
			System.out.println("filename: " + file.getOriginalFilename());
			Files.copy(file.getInputStream(), fileLocation.resolve(file.getOriginalFilename()));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
