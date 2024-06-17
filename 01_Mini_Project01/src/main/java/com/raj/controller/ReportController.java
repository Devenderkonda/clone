package com.raj.controller;



import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.raj.entity.CitizenEntity;
import com.raj.request.SurchRequest;
import com.raj.service.ReporyService;


@Controller
public class ReportController {
	@Autowired
	private ReporyService service;
	
	@GetMapping("/pdf")
	public void pdfExpost(HttpServletResponse response)throws Exception{
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition","attachment;filename=plans.pdf");
		service.exportPdf(response);
	}
	
	@GetMapping("/test")
	public void excepExport(HttpServletResponse response)throws IOException{
		response.setContentType("application/octect-stream");
		response.addHeader("Content-Disposition","attachment;filename=plans.xls");
		service.exportExcel(response);
	}
	
	@PostMapping("/search")
	public String handleSearch(@ModelAttribute("search")    SurchRequest search,Model model) {
		// System.out.println(search);
		List<CitizenEntity> plans = service.surch(search);
		model.addAttribute("plans",plans);
		init(model);
		
		return "NewFile";
	}
	
	@GetMapping("/show")
	 public String Show(Model model) {
		
		SurchRequest surchObj = new SurchRequest();
		model.addAttribute("search",surchObj );
		//List<String> planName = service.getPlanName();
		init(model);
	
		return "NewFile";
	
	}

	private void init(Model model) {
		
		model.addAttribute("names", service.getPlanName());
		model.addAttribute("status", service.getPlanStatus());
	}

	
	
}
