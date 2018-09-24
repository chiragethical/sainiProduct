package net.sc.sainicablebackend.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity

public class NewConnection {


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
		/*@NotEmpty*/
		private String dateOfRequest;
		private String status = "not installed";
		@Column(name = "is_active")	
		private boolean active = true;
		
		
		public NewConnection()
		{
				
				this.requestId = "RQID" + UUID.randomUUID().toString().substring(26).toUpperCase();
				
	
		}
		
		
		public String toString() {
			return "NewConnection [id=" + id + ", requestId=" + requestId + ", name=" + name + ", email=" + email
					 + ", phone=" + phone + ", address=" + address + ", dateOfRequest="
					+ dateOfRequest + ", status=" + status + ", active=" + active + "]";
		}
		
		
		
		// getters and setters
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getRequestId() {
			return requestId;
		}
		public void setRequestId(String requestId) {
			this.requestId = requestId;
		}
		public String getDateOfRequest() {
			return dateOfRequest;
		}
		public void setDateOfRequest(String dateOfRequest) {
			this.dateOfRequest = dateOfRequest;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public boolean isActive() {
			return active;
		}
		public void setActive(boolean active) {
			this.active = active;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		
		
}
