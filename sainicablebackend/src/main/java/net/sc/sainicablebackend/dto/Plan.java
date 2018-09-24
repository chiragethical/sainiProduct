package net.sc.sainicablebackend.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Plan {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String code;
		@NotEmpty
		private String name;
		@Size(min=20,message="Plan description too short! please add more details")
		private String description;
		@Min(value = 1, message="The Price can not be less than 1!")
		private int price;
		@Column(name="is_active")
		private boolean active;
		
		public Plan()
		{
				
				this.code = "PLN" + UUID.randomUUID().toString().substring(26).toUpperCase();		
	
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public boolean isActive() {
			return active;
		}

		public void setActive(boolean active) {
			this.active = active;
		}

		@Override
		public String toString() {
			return "Plan [id=" + id + ", code=" + code + ", name=" + name + ", description=" + description + ", price="
					+ price + ", active=" + active + "]";
		}

}
