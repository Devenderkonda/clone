package com.raj.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.raj.entity.CitizenEntity;
import com.raj.repo.CitizenPalnRepository;

@Component
public class DataLoad implements ApplicationRunner {
@Autowired
private CitizenPalnRepository citiPlanRepo;
	

	@Override
		public void run(ApplicationArguments args)throws Exception {
		CitizenEntity  ct1 = new CitizenEntity();
		citiPlanRepo.deleteAll();
		ct1.setCitizenName("raju");
		ct1.setGender("Male");
		ct1.setPlanNames("Cash");
		ct1.setPlanStatus("Approved");
		ct1.setPlanStartDate(LocalDate.now());
		ct1.setPlanEndDate(LocalDate.now().plusMonths(6));
		ct1.setBenifiAmmount(50000.00);

		CitizenEntity  ct2 = new CitizenEntity();
		ct2.setCitizenName("venkat");
		ct2.setGender("Male");
		ct2.setPlanNames("Cash");
		ct2.setPlanStatus("Denied");
		ct2.setDenialReson("Rental Income");
		
		CitizenEntity  ct3 = new CitizenEntity();
		ct3.setCitizenName("venkat");
		ct3.setGender("Male");
		ct3.setPlanNames("Cash");
		ct3.setPlanStatus("Terminated");
		ct3.setPlanStartDate(LocalDate.now().minusMonths(4));
		ct3.setPlanEndDate(LocalDate.now().plusMonths(6));
		ct3.setBenifiAmmount(5000.00);
		ct3.setTermantedDate(LocalDate.now());
		ct3.setTermantedReson("Employeed");
		
		//Food
		CitizenEntity  ct4 = new CitizenEntity();
		ct4.setCitizenName("sunil");
		ct4.setGender("Male");
		ct4.setPlanNames("food");
		ct4.setPlanStatus("Approved");
		ct4.setPlanStartDate(LocalDate.now());
		ct4.setPlanEndDate(LocalDate.now().plusMonths(6));
		ct4.setBenifiAmmount(750000.00);

		CitizenEntity  ct5 = new CitizenEntity();
		ct5.setCitizenName("usha");
		ct5.setGender("Fe-Male");
		ct5.setPlanNames("food");
		ct5.setPlanStatus("Denied");
		ct5.setDenialReson("Rental Income");
		
		CitizenEntity  ct6 = new CitizenEntity();
		ct6.setCitizenName("ajay");
		ct6.setGender("Male");
		ct6.setPlanNames("food");
		ct6.setPlanStatus("Terminated");
		ct6.setPlanStartDate(LocalDate.now().minusMonths(4));
		ct6.setPlanEndDate(LocalDate.now().plusMonths(6));
		ct6.setBenifiAmmount(5000.00);
		ct6.setTermantedDate(LocalDate.now());
		ct6.setTermantedReson("Employeed");
		
		//Medical
		CitizenEntity  ct7 = new CitizenEntity();
		ct7.setCitizenName("ganesh");
		ct7.setGender("Male");
		ct7.setPlanNames("medical");
		ct7.setPlanStatus("Approved");
		ct7.setPlanStartDate(LocalDate.now());
		ct7.setPlanEndDate(LocalDate.now().plusMonths(6));
		ct7.setBenifiAmmount(750000.00);

		CitizenEntity  ct8 = new CitizenEntity();
		ct8.setCitizenName("myru");
		ct8.setGender("Fe-Male");
		ct8.setPlanNames("medical");
		ct8.setPlanStatus("Denied");
		ct8.setDenialReson("Rental Income");
		
		CitizenEntity  ct9 = new CitizenEntity();
		ct9.setCitizenName("sathyam");
		ct9.setGender("Male");
		ct9.setPlanNames("medical");
		ct9.setPlanStatus("Terminated");
		ct9.setPlanStartDate(LocalDate.now().minusMonths(4));
		ct9.setPlanEndDate(LocalDate.now().plusMonths(6));
		ct9.setBenifiAmmount(5000.00);
		ct9.setTermantedDate(LocalDate.now());
		ct9.setTermantedReson("Employeed");
		
		//Employement
		CitizenEntity  ct10 = new CitizenEntity();
		ct10.setCitizenName("vinay");
		ct10.setGender("Male");
		ct10.setPlanNames("Employement");
		ct10.setPlanStatus("Approved");
		ct10.setPlanStartDate(LocalDate.now());
		ct10.setPlanEndDate(LocalDate.now().plusMonths(6));
		ct10.setBenifiAmmount(750000.00);

		CitizenEntity  ct11 = new CitizenEntity();
		ct11.setCitizenName("barth");
		ct11.setGender("Male");
		ct11.setPlanNames("Employement");
		ct11.setPlanStatus("Denied");
		ct11.setDenialReson("Rental Income");
		
		CitizenEntity  ct12 = new CitizenEntity();
		ct12.setCitizenName("sathyam");
		ct12.setGender("Male");
		ct12.setPlanNames("medical");
		ct12.setPlanStatus("Terminated");
		ct12.setPlanStartDate(LocalDate.now().minusMonths(4));
		ct12.setPlanEndDate(LocalDate.now().plusMonths(6));
		ct12.setBenifiAmmount(5000.00);
		ct12.setTermantedDate(LocalDate.now());
		ct12.setTermantedReson("Employeed");
		List<CitizenEntity> list = Arrays.asList(ct1,ct2,ct3,ct4,ct5,ct6,ct7,ct8,ct9,ct10,ct11,ct12);
		
		citiPlanRepo.saveAll(list);
		
		}
	
	

}
