package com.companydatabase.request;

import java.util.List;

import com.companydatabase.entity.Address;
import com.companydatabase.entity.Registration;
import com.companydatabase.entity.Users;

public class CompanyRequest {
   
	private Long companyId;
	private String companyName;
	private String phoneNumber;
	private Boolean isDeleted;
	private String emailId;
	private Registration registration;
	private List<Users> users;
	 private Address address;
	
	public Long getCompanyId() {
		return companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}


	public String getEmailId() {
		return emailId;
	}

	public Registration getRegistration() {
		return registration;
	}

	public List<Users> getUsers() {
		return users;
	}
	public Address getAddress() {
		return address;
	}

	
}














