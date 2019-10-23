package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	@RequestMapping("/toUpload.do")
	public String toUpload() {
		return "upload";
	}
	
	@RequestMapping("/upload.do")
	public String upload(@RequestParam(value="file", required = false)
						 MultipartFile file,
						 HttpServletRequest request, ModelMap model) {
		String path = request.getSession().getServletContext().getRealPath("upload");
		String fileName = file.getOriginalFilename();
		System.out.println(path);
		File targetFile = new File(path, fileName);
		if(!targetFile.exists()) {
			targetFile.mkdirs();
		}
//		±£´æ
		try {
			file.transferTo(targetFile);
			model.addAttribute("fileUrl", request.getContextPath() + "/upload/" + fileName);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "result";
	}
	
	@RequestMapping("/uploads.do")
	public String uploads(@RequestParam(value = "file", required = false)
						  MultipartFile[] files,
						  HttpServletRequest request,
						  ModelMap model) {
		List<String> urls = new ArrayList<String>();
		for (MultipartFile file : files) {
			String path = request.getSession().getServletContext().getRealPath("upload");
			String fileName = file.getOriginalFilename();
			System.out.println(path);
			File targetFile = new File(path, fileName);
			if(!targetFile.exists()) {
				targetFile.mkdirs();
			}
//			±£´æ
			try {
				file.transferTo(targetFile);
				urls.add(request.getContextPath() + "/upload/" + fileName);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("fileUrls", urls);
		return "result";
	}
}
