package com.raj.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.raj.entity.CitizenEntity;

@EnableJpaRepositories
public interface CitizenPalnRepository extends JpaRepository<CitizenEntity, Integer> {
	
	  @Query(value = "SELECT distinct(plan_Names) FROM raju.citizen_plans_info",nativeQuery=true)
	  
	  public List<String> getPlanNames();
	  
	  @Query(value = "SELECT distinct(plan_Status) FROM raju.citizen_plans_info",nativeQuery=true) 
	  public List<String> getPlanStatus();
	 

}
