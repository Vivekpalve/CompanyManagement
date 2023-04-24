package com.companydatabase.transformer;

import com.companydatabase.entity.Address;
import com.companydatabase.response.AddressResponse;

public class AddressResponseConverter {
	 public static AddressResponse convertToResponse(Address address) {
		 AddressResponse addressResponse = new AddressResponse();
		 
		 addressResponse.setCompanyId(address.getCompanyId());
		 addressResponse.setCity(address.getCity());
		 addressResponse.setState(address.getState());
		 addressResponse.setCountry(address.getCountry()); 
		 addressResponse.setPincode(address.getPincode());
		 addressResponse.setCompany(address.getCompany());
	        return addressResponse;
	    }
}
