package com.companydatabase.request;

import com.companydatabase.entity.Company;

public class AddressRequest {

	private Long companyId;
    private String city;
    private String state;
    private String country;
    private Long pincode;
    private Company company;
    
	public Long getCompanyId() {
		return companyId;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public String getCountry() {
		return country;
	}
	
	public Long getPincode() {
		return pincode;
	}

	public Company getCompany() {
		return company;
	}

	
	
}
