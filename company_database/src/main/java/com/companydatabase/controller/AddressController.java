package com.companydatabase.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.companydatabase.request.AddressRequest;
import com.companydatabase.response.AddressResponse;
import com.companydatabase.service.AddressService;

@RestController
public class AddressController {

	
	@Autowired
	private AddressService addressService;
	
	 @GetMapping("/address")
	    public List<AddressResponse>getAllAddress(){
	        return addressService.getAllRegistrations();
	    }
	 
	//get data by id
	    @GetMapping("/address/{companyId}")
	    public ResponseEntity<AddressResponse> getAddressById(@PathVariable Long companyId) {
	        Optional<AddressResponse> optionalAddress = addressService.getAddressById(companyId);
	        if (optionalAddress.isPresent()) {
	            return ResponseEntity.ok(optionalAddress.get());
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    
	    //create company
	    @PostMapping("/address/post")
	    public AddressResponse addAddress(@RequestBody AddressRequest addressRequest) {
	    	return addressService.createAddress(addressRequest);
	    }
	    //update
	    @PutMapping("/address/update/{companyId}")
	    public String updateUpdate(@PathVariable Long companyId, @RequestBody AddressRequest addressRequest) {
	        return addressService.updateAddress(companyId, addressRequest);
	       
	    }
	  //delete data
	    @DeleteMapping("/address/delete/{companyId}")
	    public String deleteaddress(@PathVariable Long companyId) {
	        return addressService.deleteUser(companyId);
	      
	    }
	    
}
