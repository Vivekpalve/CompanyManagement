package com.companydatabase.service;

import java.util.List;
import java.util.Optional;

import com.companydatabase.exception.ResourceNotFoundException;
import com.companydatabase.request.UserRequest;
import com.companydatabase.response.UserResponse;

public interface UserService {

	List<UserResponse> getAllUsers();
	Optional<UserResponse> getUsersById(Long userId) throws ResourceNotFoundException;
	String updateUser(Long userId, UserRequest userRequest);
	String deleteUser(Long userId) throws ResourceNotFoundException;
	UserResponse createUser(UserRequest userRequest) throws ResourceNotFoundException;
	List<UserResponse> getUsersByCompanyId(Long companyId);
	
}
