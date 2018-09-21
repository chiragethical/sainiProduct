package net.sc.sainicablebackend.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class NewConnection {


		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@NotNull
		private int id;
		@Column(name = "request_id")	
		@NotNull
		private String requestId;
		@NotEmpty
		private String name;
		@Email
		@NotEmpty
		private String email;
		@NotEmpty
		@Size(min=10,max=10,message="Not a valid contact number, Must be of 10 digit")
		private String phone;
		@NotEmpty
		private String address;
		@Column(name = "date_of_request")	
		@NotEmpty
		private String dateOfRequest;
		@NotEmpty
		private String status = "Not Installed";
		@Column(name = "is_active")	
		@NotEmpty
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
