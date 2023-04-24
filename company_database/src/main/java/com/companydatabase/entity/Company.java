package com.companydatabase.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "company")

public class Company {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long companyId;
    private String companyName;
    private String phoneNumber;
    private String emailId;
    private Boolean isDeleted;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_registration_id")
    @JsonManagedReference
    private Registration registration;

   
    @OneToMany(cascade=CascadeType.ALL)
     @JoinColumn(name="fk_company_id")
    @JsonManagedReference
    private List<Users> users;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_address_id")
    @JsonManagedReference
    private Address address;
    
	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
 
	public Company(Long companyId, String companyName, String phoneNumber, String emailId, Boolean isDeleted,
			Registration registration, List<Users> users, Address address) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.isDeleted = isDeleted;
		this.registration = registration;
		this.users = users;
		this.address = address;
	}


	public Company() {
		super();
		
	}
   

}










