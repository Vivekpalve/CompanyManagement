package com.companydatabase.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.companydatabase.entity.Company;
import com.companydatabase.entity.Users;
import com.companydatabase.exception.ResourceNotFoundException;
import com.companydatabase.repository.CompanyRepository;
import com.companydatabase.repository.UserRepository;
import com.companydatabase.request.UserRequest;
import com.companydatabase.response.UserResponse;
import com.companydatabase.service.UserService;
import com.companydatabase.successfullmessage.MessageSuccessfull;
import com.companydatabase.transformer.UserRequestConverter;
import com.companydatabase.transformer.UserResponseConverter;


@Service
public class UserServiceImpl implements UserService{

	
	   @Autowired
	    private UserRepository userRepository;
	   
	   @Autowired
	   private CompanyRepository companyRepository;
	   
	   @Autowired
	   private MessageSuccessfull  messageSuccessfull;
	   
	  @Override
	  public List<UserResponse> getAllUsers() {
		List<Users> users = userRepository.findAll();
		 return users.stream().map(UserResponseConverter::convertToResponse).collect(Collectors.toList());
	}

	@Override
	public Optional<UserResponse> getUsersById(Long userId) throws ResourceNotFoundException {
		
		Optional<Users> userOptional = userRepository.findById(userId);
	        if (userOptional.isPresent()) {
	        	UserResponse userResponse = UserResponseConverter.convertToResponse(userOptional.get());
	            return Optional.of(userResponse);
	        } 
	        else {
	        	 throw new ResourceNotFoundException("User", "id", userId);
	        }
		}
	

	@Override
	public String updateUser(Long userId, UserRequest userRequest) {
	    Optional<Users> optionalUser = userRepository.findById(userId);
	    if (optionalUser.isPresent()) {
	        Users user = optionalUser.get();
	        Company company = userRequest.getCompany();
	        if (company != null) {
	            if (company.getIsDeleted()) {
	                return "Cannot update user with a deleted company.";
	            } else {
	                user.setCompany(company);
	            }
	        }
	        UserRequestConverter.updateEntity(user, userRequest);
	        userRepository.save(user);
	        return "User updated successfully.";
	    } else {
	        return "User not found.";
	    }
	}


	@Override
	public String deleteUser(Long userId) throws ResourceNotFoundException{
	    Optional<Users> optionalUser = userRepository.findById(userId);
	    if (optionalUser.isPresent()) {
	        Users user = optionalUser.get();
	        user.setDeleted(true);
            user.isDeleted();
	        userRepository.save(user);
	        return messageSuccessfull.dataDeleted("User");
	    } else {
	    	throw new ResourceNotFoundException("User", "id", userId);
	    }
	}



	@Override
	
	public UserResponse createUser(UserRequest userRequest) throws ResourceNotFoundException {
	    if(userRequest.getCompany() != null && !userRequest.getCompany().getIsDeleted()) {
	        Company company = companyRepository.findById(userRequest.getCompany().getCompanyId())
	                .orElseThrow(() -> new ResourceNotFoundException("Company", "id", userRequest.getCompany().getCompanyId()));

	        Users user = UserRequestConverter.toEntity(userRequest);
	        user.setCompany(company);

	        Users savedUser = userRepository.save(user);
	        return UserResponseConverter.convertToResponse(savedUser);
	    }
	    throw new ResourceNotFoundException("Company", "id", userRequest.getCompany().getCompanyId());
	}


	@Override
	public List<UserResponse> getUsersByCompanyId(Long companyId) {
		try {
			List<Users> users = userRepository.findByCompany_CompanyId(companyId);
			return users.stream().map(UserResponseConverter::convertToResponse).collect(Collectors.toList());
		} catch (Exception e) {
			return Collections.emptyList();
		}
	}
}