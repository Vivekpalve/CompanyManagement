package com.companydatabase.transformer;

import java.time.LocalDate;
import com.companydatabase.entity.Registration;
import com.companydatabase.request.RegistrationRequest;


public class RegistrationRequestConverter {
	
public static Registration toEntity(RegistrationRequest request) {
		
	Registration registration = new Registration();
	
	registration.setRegistrationId(request.getRegistrationId());
	registration.setId(request.getId());
	registration.setLegalName(request.getLegalName());
	registration.setDOR(LocalDate.now());
	registration.setCompany(request.getCompany());
        return registration;
    }

public static Registration updateEntity(Registration registration, RegistrationRequest registrationRequest) {
	
	registration.setRegistrationId(registrationRequest.getRegistrationId());
	registration.setId(registrationRequest.getId());
	registration.setLegalName(registrationRequest.getLegalName());
	registration.setDOR(LocalDate.now());
	registration.setCompany(registrationRequest.getCompany());
    return registration;
	
}

//registartion setting
public static Registration toEntity(Registration registration) {
	
	Registration registrationobject = new Registration();
	
	registrationobject.setRegistrationId(registration.getRegistrationId());
	registrationobject.setId(registration.getId());
	registrationobject.setLegalName(registration.getLegalName());
	registrationobject.setDOR(LocalDate.now());
	registrationobject.setCompany(registration.getCompany());
    return registration;
}
}
