package com.companydatabase.service;

import java.util.List;
import java.util.Optional;

import com.companydatabase.request.AddressRequest;
import com.companydatabase.response.AddressResponse;

public interface AddressService {

	List<AddressResponse> getAllRegistrations();

	Optional<AddressResponse> getAddressById(Long companyId);

	AddressResponse createAddress(AddressRequest addressRequest);

	String updateAddress(Long companyId, AddressRequest addressRequest);

	String deleteUser(Long companyId);

}
