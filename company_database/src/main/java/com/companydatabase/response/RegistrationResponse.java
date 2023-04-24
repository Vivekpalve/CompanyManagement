package com.companydatabase.response;

import java.time.LocalDate;
import java.util.UUID;

import com.companydatabase.entity.Company;
import com.companydatabase.entity.Registration;

public class RegistrationResponse {
	private UUID registrationId;
	private String legalName;
	private LocalDate DOR;
	private Long id;
    private Company company;
    
	public UUID getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(UUID registrationId) {
		this.registrationId = registrationId;
	}
	public String getLegalName() {
		return legalName;
	}
	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}
	public LocalDate getDOR() {
		return DOR;
	}
	public void setDOR(LocalDate dOR) {
		DOR = dOR;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	
	
    
}
