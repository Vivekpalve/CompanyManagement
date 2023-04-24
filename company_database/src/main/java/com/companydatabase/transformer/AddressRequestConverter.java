package com.companydatabase.transformer;

import com.companydatabase.entity.Address;
import com.companydatabase.request.AddressRequest;

public class AddressRequestConverter {

	public static Address toEntity(AddressRequest addressRequest) {
		
		Address address = new Address();
		address.setCity(addressRequest.getCity());
		address.setState(addressRequest.getState());
		address.setCountry(addressRequest.getCountry()); 
		address.setPincode(addressRequest.getPincode());
		address.setCompany(addressRequest.getCompany());
	    return address;
		
	}

	public static void updateEntity(Address address, AddressRequest addressRequest) {
		address.setCity(addressRequest.getCity());
		address.setState(addressRequest.getState());
		address.setCountry(addressRequest.getCountry()); 
		address.setPincode(addressRequest.getPincode());
		address.setCompany(addressRequest.getCompany());
	}
	
   public static Address toEntity(Address address2) {	
		Address address = new Address();
		address.setCity(address2.getCity());
		address.setState(address2.getState());
		address.setCountry(address2.getCountry()); 
		address.setPincode(address2.getPincode());
		address.setCompany(address2.getCompany());
	    return address;
		
	}

}
