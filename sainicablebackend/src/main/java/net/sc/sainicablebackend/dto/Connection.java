package net.sc.sainicablebackend.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class Connection {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "request_id")	
	private String requestId;
	@NotBlank(message = "Please enter the name!")
	private String name;
	@Email(message = "Please enter correct Email!")
	@NotBlank(message = "Please enter the email!")
	private String email;
	@Size(min=10,max=10,message="Not a valid contact number, Must be of 10 digit")
	private String phone;
	@NotEmpty(message = "Please enter the Address")
	private String address;
	@Column(name = "date_of_request")	
	private String dateOfRequest;
	private String status = "Not Installed";
	@Column(name = "is_active")	
	private boolean active = true;
	@Column(name = "is_active")	
	private String boxId;

}
