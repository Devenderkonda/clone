package com.raj.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.raj.entity.CitizenEntity;
import com.raj.request.SurchRequest;

public interface ReporyService {
	
	  public List<String> getPlanName(); public List<String> getPlanStatus();
	  public List<CitizenEntity>surch(SurchRequest request);
	  public void  exportExcel(HttpServletResponse response) throws IOException; 
	 
	boolean exportPdf(HttpServletResponse response)throws  IOException, Exception;
	 
	

}
