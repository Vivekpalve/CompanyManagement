package com.companydatabase.transformer;

import com.companydatabase.entity.Company;
import com.companydatabase.response.CompanyResponse;
import org.springframework.stereotype.Component;

@Component
public class ResponceConverter {
	
	public static CompanyResponse convertToResponse(Company company) {
	    CompanyResponse companyResponse = new CompanyResponse(); 
	    
	    companyResponse.setCompanyId(company.getCompanyId());
	    companyResponse.setCompanyName(company.getCompanyName());
	    companyResponse.setEmailId(company.getEmailId());
	    companyResponse.setPhoneNumber(company.getPhoneNumber());
	    companyResponse.setIsDeleted(company.getIsDeleted());
	    companyResponse.setRegistration(company.getRegistration());
	    companyResponse.setUsers(company.getUsers());
	    companyResponse.setAddress(company.getAddress());
	    if(companyResponse.getIsDeleted() != null) {
	        companyResponse.setIsDeleted(company.getIsDeleted());
	    }
	    return companyResponse;
	}

	
	
}

