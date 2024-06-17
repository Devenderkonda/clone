package com.raj.utill;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.raj.entity.CitizenEntity;
import com.raj.repo.CitizenPalnRepository;
@Component
public class PdfGenerator {
	private CitizenPalnRepository ctRepo;
	public boolean generator(HttpServletResponse response,List<CitizenEntity> list,File f)throws Exception {
		Document documnent=new Document(PageSize.A4);
		PdfWriter pdfWriter = PdfWriter.getInstance(documnent,response.getOutputStream());
		PdfWriter.getInstance(documnent,new FileOutputStream(f));
		documnent.open();
		Paragraph paragraph = new Paragraph("citizen plan info");
		PdfPTable table = new PdfPTable(6);
		table.addCell("CitizenId");
		table.addCell("citizenName");
		table.addCell("Plan Name");
		table.addCell("planStatus");
		table.addCell("plan Start Date");
		table.addCell("plan End date");
		table.addCell("Benifit Amount");
		//List<CitizenEntity> plans = planRepo.findAll();
		for( CitizenEntity plan:list)
		{
			table.addCell(String.valueOf(plan.getCitizenId()));
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getPlanNames());
			table.addCell(plan.getPlanStartDate()+"");
			table.addCell(plan.getPlanEndDate()+"");
			table.addCell(plan.getBenifiAmmount()+"");
			
			
		
		}
		
		documnent.add(table);
		//documnent.add(paragraph);
		documnent.close();
	return true;
	}
	}

