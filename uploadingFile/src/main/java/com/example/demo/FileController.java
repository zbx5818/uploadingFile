package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileController {
	@Autowired
	FileService uploader;
	
	@PostMapping("/")
	public String fileUploader(@RequestParam("file") MultipartFile file, RedirectAttributes att) {
		uploader.storeFile(file);
		att.addFlashAttribute("message", "succeed");
		return "redirect:/";
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
}
