package com.raj.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="citizen_plans_info")
public class CitizenEntity {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer citizenId;
	private String citizenName;
	private String gender;
	private String planNames;
	private String planStatus;
	private LocalDate planStartDate;
	private LocalDate  planEndDate;
	private  Double benifiAmmount;
	private  String benifiReson;
	private LocalDate termantedDate;
	private String termantedReson;
	private String denialReson;
	public String getDenialReson() {
		return denialReson;
	}
	public void setDenialReson(String denialReson) {
		this.denialReson = denialReson;
	}
	public Integer getCitizenId() {
		return citizenId;
	}
	public void setCitizenId(Integer citizenId) {
		this.citizenId = citizenId;
	}
	public String getCitizenName() {
		return citizenName;
	}
	public void setCitizenName(String citizenName) {
		this.citizenName = citizenName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public String getPlanNames() {
		return planNames;
	}
	public void setPlanNames(String planNames) {
		this.planNames = planNames;
	}
	
	public String getPlanStatus() {
		return planStatus;
	}
	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}
	public LocalDate getPlanStartDate() {
		return planStartDate;
	}
	public void setPlanStartDate(LocalDate planStartDate) {
		this.planStartDate = planStartDate;
	}
	public LocalDate getPlanEndDate() {
		return planEndDate;
	}
	public void setPlanEndDate(LocalDate planEndDate) {
		this.planEndDate = planEndDate;
	}
	public Double getBenifiAmmount() {
		return benifiAmmount;
	}
	public void setBenifiAmmount(Double benifiAmmount) {
		this.benifiAmmount = benifiAmmount;
	}
	public String getBenifiReson() {
		return benifiReson;
	}
	public void setBenifiReson(String benifiReson) {
		this.benifiReson = benifiReson;
	}
	public LocalDate getTermantedDate() {
		return termantedDate;
	}
	public void setTermantedDate(LocalDate termantedDate) {
		this.termantedDate = termantedDate;
	}
	public String getTermantedReson() {
		return termantedReson;
	}
	public void setTermantedReson(String termantedReson) {
		this.termantedReson = termantedReson;
	}
	

}
