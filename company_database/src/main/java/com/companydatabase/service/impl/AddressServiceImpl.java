package com.companydatabase.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companydatabase.entity.Address;
import com.companydatabase.repository.AddressRepository;
import com.companydatabase.request.AddressRequest;
import com.companydatabase.response.AddressResponse;
import com.companydatabase.service.AddressService;
import com.companydatabase.transformer.AddressRequestConverter;
import com.companydatabase.transformer.AddressResponseConverter;

@Service
public class AddressServiceImpl implements AddressService {

	
	
	  @Autowired
	    private AddressRepository addressRepository;
	  
	@Override
	public List<AddressResponse> getAllRegistrations() {
		    List<Address> address = addressRepository.findAll();
		    return address.stream().map(AddressResponseConverter::convertToResponse).collect(Collectors.toList());
		
	}

	@Override
	public Optional<AddressResponse> getAddressById(Long companyId) {
		  Optional<Address> addressOptional = addressRepository.findById(companyId);
	        if (addressOptional.isPresent()) {
	        	AddressResponse addressResponse = AddressResponseConverter.convertToResponse(addressOptional.get());
	            return Optional.of(addressResponse);
	        } else {
	            return Optional.empty();
	        }
	}

	@Override
	public AddressResponse createAddress(AddressRequest addressRequest) {
		Address address=AddressRequestConverter.toEntity(addressRequest);
		Address add=this.addressRepository.save(address);
		return AddressResponseConverter.convertToResponse(add);
	}

	@Override
	public String updateAddress(Long companyId, AddressRequest addressRequest) {
		 Optional<Address> optionalAddress = addressRepository.findById(companyId);
	        if (optionalAddress.isPresent()) {
	        	Address address = optionalAddress.get();
	        	AddressRequestConverter.updateEntity(address, addressRequest);
	            addressRepository.save(address);
	            return "Company updated successfully.";
	        } else {
	            return "Company not found.";
	        }
		
	}

	@Override
	public String deleteUser(Long companyId) {
		addressRepository.deleteById(companyId);
		return "deleted successfully";
	}

	

}
