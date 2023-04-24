package com.companydatabase.transformer;

import com.companydatabase.entity.Company;
import com.companydatabase.request.CompanyRequest;

public class RequestConverter {
	public static Company toEntity(CompanyRequest request) {
		
        Company company = new Company();
      
        company.setCompanyName(request.getCompanyName());
        company.setEmailId(request.getEmailId());
        company.setPhoneNumber(request.getPhoneNumber());
        company.setIsDeleted(request.getIsDeleted());
        company.setRegistration(RegistrationRequestConverter.toEntity(request.getRegistration()));
        company.setUsers(UserRequestConverter.toEntity(request.getUsers()));
        company.setAddress(AddressRequestConverter.toEntity(request.getAddress()));
        return company;
    }

	public static Company updateEntity(Company company, CompanyRequest companyRequest) {
		company.setCompanyName(companyRequest.getCompanyName());
		  company.setEmailId(companyRequest.getEmailId());
	        company.setPhoneNumber(companyRequest.getPhoneNumber());
	        company.setIsDeleted(companyRequest.getIsDeleted());
	        company.setRegistration(companyRequest.getRegistration());
	        company.setUsers(companyRequest.getUsers());
	        company.setAddress(companyRequest.getAddress());
        return company;
	}

	public static Company toEntity(Company company2) {
		
        Company company = new Company();
      
        company.setCompanyName(company2.getCompanyName());
        company.setEmailId(company2.getEmailId());
        company.setPhoneNumber(company2.getPhoneNumber());
        company.setIsDeleted(company2.getIsDeleted());
        company.setRegistration(RegistrationRequestConverter.toEntity(company2.getRegistration()));
        company.setUsers(UserRequestConverter.toEntity(company2.getUsers()));
        company.setAddress(AddressRequestConverter.toEntity(company2.getAddress()));
        return company;
    }
	
}

