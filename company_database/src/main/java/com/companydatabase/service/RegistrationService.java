package com.companydatabase.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.companydatabase.entity.Company;
import com.companydatabase.request.RegistrationRequest;
import com.companydatabase.response.RegistrationResponse;


public interface RegistrationService {
	 List<RegistrationResponse> getAllRegistrations();
	 public Optional<RegistrationResponse> getRegistrationById(UUID registrationId);
	 RegistrationResponse createRegistration(RegistrationRequest registrationRequest);
	 String updateRegistration(UUID registrationId, RegistrationRequest registrationRequest);
	String deleteRegistration(UUID registrationId);
	
	
	
}
