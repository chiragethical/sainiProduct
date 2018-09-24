package net.sc.sainicablebackend.dao;

import java.util.List;

import net.sc.sainicablebackend.dto.Plan;

public interface PlanDAO {
	
	Plan get(int planId);
	List<Plan> list();	
	boolean add(Plan plan);
	boolean update(Plan plan);
	boolean delete(Plan plan);

	List<Plan> listActivePlans();	

}
