package com.companydatabase.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companydatabase.entity.Company;
import com.companydatabase.entity.Registration;
import com.companydatabase.repository.RegistrationRepository;
import com.companydatabase.request.RegistrationRequest;
import com.companydatabase.response.RegistrationResponse;
import com.companydatabase.service.RegistrationService;
import com.companydatabase.transformer.RegistrationRequestConverter;
import com.companydatabase.transformer.RegistrationResponseConverter;
import com.companydatabase.transformer.RequestConverter;
import com.companydatabase.transformer.ResponceConverter;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

	@Override
	public List<RegistrationResponse> getAllRegistrations() {
		List<Registration> companies = registrationRepository.findAll();
		 return companies.stream().map(RegistrationResponseConverter::convertToResponse).collect(Collectors.toList());
			
	}

	@Override
	public Optional<RegistrationResponse> getRegistrationById(UUID registrationId) {
    	 Optional<Registration> registrationOptional = registrationRepository.findById(registrationId);
        if (registrationOptional.isPresent()) {
        	RegistrationResponse registrationResponse = RegistrationResponseConverter.convertToResponse(registrationOptional.get());
            return Optional.of(registrationResponse);
        } else {
            return Optional.empty();
        }
	
	}

	@Override
	public RegistrationResponse createRegistration(RegistrationRequest registrationRequest) {
		Registration registration=RegistrationRequestConverter.toEntity(registrationRequest);
		Registration reg=this.registrationRepository.save(registration);
		return RegistrationResponseConverter.convertToResponse(reg);
		
	}

	@Override
	public String updateRegistration(UUID registrationId, RegistrationRequest registrationRequest) {
		  Optional<Registration> registrationOptional = registrationRepository.findById(registrationId);
	        if (registrationOptional.isPresent()) {
	        	Registration registration = registrationOptional.get();
	        	RegistrationRequestConverter.updateEntity(registration, registrationRequest);
	            registrationRepository.save(registration);
	            return "Company updated successfully.";
	        } else {
	            return "Company not found.";
	        }
	}

	@Override
	public String deleteRegistration(UUID registrationId) {
		
		registrationRepository.deleteById(registrationId);
			return "deleted successfully";

	}



}

