package com.companydatabase.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.companydatabase.entity.Company;
import com.companydatabase.request.CompanyRequest;
import com.companydatabase.request.RegistrationRequest;
import com.companydatabase.response.CompanyResponse;
import com.companydatabase.response.RegistrationResponse;
import com.companydatabase.service.RegistrationService;


@RestController
public class RegistrationController {

	@Autowired
	private RegistrationService registrationservice;
	
	 @GetMapping("/registration")
	    public List<RegistrationResponse>getAllRegistrations(){
	        return registrationservice.getAllRegistrations();
	    }
	 
	 @GetMapping("/registration/{registrationId:[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}}")
	 public ResponseEntity<RegistrationResponse> getRegistrationById(@PathVariable UUID registrationId) {
		 Optional<RegistrationResponse> registrationOptional = registrationservice.getRegistrationById(registrationId);
	        if (registrationOptional.isPresent()) {
	            return ResponseEntity.ok(registrationOptional.get());
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	 }
	 
	//create company
	    @PostMapping("/registration/post")
	    public RegistrationResponse addRegistration(@RequestBody RegistrationRequest registrationRequest) {
	    	return registrationservice.createRegistration(registrationRequest);
	    }
	    
	  //update
	    @PutMapping("/registration/update/{registrationId}")
	    public String updateRegistration(@PathVariable  UUID registrationId, @RequestBody  RegistrationRequest registrationRequest) {
	        return registrationservice.updateRegistration(registrationId, registrationRequest);
	       
	    }
	    
	  //delete data
	    @DeleteMapping("/registration/delete/{registrationId}")
	    public String deleteRegistration(@PathVariable UUID registrationId) {
	        return registrationservice.deleteRegistration(registrationId);
	      
	    }
}


