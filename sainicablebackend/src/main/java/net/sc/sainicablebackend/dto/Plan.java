package net.sc.sainicablebackend.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Plan {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		//@NotNull
		private int plan_id;
		//@NotNull
		//@NotEmpty
		
		private String name;
		//@NotNull
		//@Size(min=20,message="Plan description too short! please add more details")
		private String description;
		//@NotNull
		private int price;

}
