package com.companydatabase.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class Users {
        
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long userId;
	    private String firstName;
	    private String lastName;
	    private String type;
	    private String email;
	    private String password;
	    private boolean isDeleted;
	    
	    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name="fk_company_id",referencedColumnName = "companyId")
	    @JsonBackReference
	    private Company company;
	    
	    public Company getCompany() {
	 			return company;
	 		}

	 	public void setCompany(Company company) {
	 			this.company = company;
	 	}
	 		
		public Long getUserId() {
			return userId;
		}


		public void setUserId(Long userId) {
			this.userId = userId;
		}


		public String getFirstName() {
			return firstName;
		}


		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}


		public String getLastName() {
			return lastName;
		}


		public void setLastName(String lastName) {
			this.lastName = lastName;
		}


		public String getType() {
			return type;
		}


		public void setType(String type) {
			this.type = type;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getPassword() {
			return password;
		}


		 public void setPassword(String password) {
		        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		        this.password = encoder.encode(password);
		    }
		
		 public boolean isDeleted() {
				return isDeleted;
			}

			public void setDeleted(boolean isDeleted) {
				this.isDeleted = isDeleted;
			}	

	
		public Users(Long userId, String firstName, String lastName, String type, String email, String password,
				boolean isDeleted, Company company) {
			super();
			this.userId = userId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.type = type;
			this.email = email;
			this.password = password;
			this.isDeleted = isDeleted;
			this.company = company;
		}

		public Users() {
			
		}

		 
		@Override
		public String toString() {
			return "Users [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", type=" + type
					+ ", email=" + email + ", password=" + password + ", isDeleted=" + isDeleted + ", company="
					+ company + "]";
		}

		

}
