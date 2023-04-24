package com.companydatabase.request;

import java.time.LocalDate;
import java.util.UUID;
import com.companydatabase.entity.Company;

public class RegistrationRequest {

	private UUID registrationId;
	private String legalName;
	private LocalDate DOR;
	private Long id;
    private Company company;
    
	public UUID getRegistrationId() {
		return registrationId;
	}

	public String getLegalName() {
		return legalName;
	}

	public LocalDate getDOR() {
		return DOR;
	}

	public Long getId() {
		return id;
	}

	public Company getCompany() {
		return company;
	}




    
}
