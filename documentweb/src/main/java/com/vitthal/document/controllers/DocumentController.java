package com.vitthal.document.controllers;


import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.vitthal.document.entites.Document;
import com.vitthal.document.repos.DocumentRepository;

@Controller
public class DocumentController {

	@Autowired
	private DocumentRepository documentRepository;

	@RequestMapping(value = "/dispalyUpload")
	public String dispalyUpload(ModelMap modelMap) {
		/*List<Document> documents = documentRepository.findAll();
		System.out.println("document size:" + documents.size());
		modelMap.addAttribute("documents", documents);*/
		return "documentUpload";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String uploadDocument(@RequestParam("document") MultipartFile multipartFile, @RequestParam("id") Long id,
			ModelMap modelMap) {
		Document document = new Document();
		try{
		document.setId(id);
		document.setName(multipartFile.getOriginalFilename());
	
			document.setData(multipartFile.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		documentRepository.save(document);
		List<Document> documents = documentRepository.findAll();
		System.out.println("document size:" + documents.size());
		modelMap.addAttribute("documents", documents);
		return "documentUpload";
	}
	
	@RequestMapping("/download")
	public StreamingResponseBody download(@RequestParam("id") Long id,HttpServletResponse response) {
		Document document = documentRepository.findOne(id);
		byte[] data = document.getData();
		
		response.setHeader("Content-Disposition", "attachment;filename="+document.getName());
		//response.setHeader("Content-Disposition", "attachment;filename=downloaded.jpeg");
		return outputStream->{
			outputStream.write(data);
		};
	}
}
