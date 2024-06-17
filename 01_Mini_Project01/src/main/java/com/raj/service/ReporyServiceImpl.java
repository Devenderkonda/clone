package com.raj.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.raj.entity.CitizenEntity;
import com.raj.repo.CitizenPalnRepository;
import com.raj.request.SurchRequest;
import com.raj.utill.EmailUtils;
import com.raj.utill.ExcelGenerator;
import com.raj.utill.PdfGenerator;


@Service
public class ReporyServiceImpl implements ReporyService {

	@Autowired
	private CitizenPalnRepository planRepo;
	@Override
	public List<String> getPlanName() {
		
		return planRepo.getPlanNames();
	}
	
	@Autowired
	private EmailUtils email;
	@Autowired
	private ExcelGenerator excepgenerator;
	@Autowired
	private PdfGenerator    pdfgenerator;

	@Override
	public List<String> getPlanStatus() {
		
		return planRepo.getPlanStatus();
	}

	@Override
	public List<CitizenEntity> surch(SurchRequest request) {
		CitizenEntity entity = new CitizenEntity();
		if(null!=request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setPlanNames(request.getPlanName());
		}
		if(null!=request.getPlanStatus()&&!"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		if(null!=request.getGender()&&!"".equals(request.getGender()))
		{
			entity.setGender(request.getGender());
		}
			if(null!=request.getStartDate()&&!"".equals(request.getStartDate())) {
				String startDate = request.getStartDate();
				DateTimeFormatter Formattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate localdate = LocalDate.parse(startDate,Formattern);
				entity.setPlanStartDate(localdate);
			}
			if(null!=request.getEndDate()&&!"".equals(request.getEndDate())) {
				String endDate=request.getEndDate();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate localdate = LocalDate.parse(endDate,formatter);
				entity.setPlanEndDate(localdate);
			}
		
		return planRepo.findAll(Example.of(entity));
	}

	@Override
	public void exportExcel(HttpServletResponse response) throws IOException{
		List<CitizenEntity> all = planRepo.findAll();
		File file = new File("plans.xls");
		excepgenerator.genaretor(response,all,file);
		
		String subject="Test Message Subject";
		String body="<h1>Test Mail Body</h1>";
		String to="pilliraju9024@gmail.com";
		email.sendMail1(subject, body, to,file);
		file.delete();
		
	}
		 	

	
	@Override
	public boolean exportPdf(HttpServletResponse response)throws Exception {
		File file = new File("plans.pdf");
		List<CitizenEntity> all = planRepo.findAll();
	
		pdfgenerator.generator(response, all,file);
		String subject="Test Message Subject";
		String body="<h1> Test Mail BOdy</H1>";
		String to="Raju@gamil.com";
		email.sendMail1(subject, body, to,file);
		file.delete();
		return true;

}
}

