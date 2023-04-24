package com.companydatabase.transformer;

import java.util.List;
import java.util.stream.Collectors;
import com.companydatabase.entity.Users;
import com.companydatabase.request.UserRequest;

public class UserRequestConverter {

	public static Users updateEntity(Users user, UserRequest userRequest) {
		user.setUserId(userRequest.getUserId());
		user.setFirstName(userRequest.getFirstName());
		user.setLastName(userRequest.getLastName());
		user.setType(userRequest.getType()); 
		user.setEmail(userRequest.getEmail()); 
		user.setPassword(userRequest.getPassword());
//		user.setCompany(userRequest.getCompany());
		user.setDeleted(userRequest.isDeleted());
		return user;
	}

	public static Users toEntity(UserRequest userRequest) {
		Users user=new Users();
		user.setUserId(userRequest.getUserId());
		user.setFirstName(userRequest.getFirstName());
		user.setLastName(userRequest.getLastName());
		user.setType(userRequest.getType()); 
		user.setEmail(userRequest.getEmail()); 
		user.setPassword(userRequest.getPassword());
		user.setCompany(userRequest.getCompany());
        user.setDeleted(userRequest.isDeleted());
		return user;
	}

	public static List<Users> toEntity(List<Users> userList) {
		  return userList.stream()
			        .map(userRequest -> {
			            Users user = new Users();
	
			            user.setUserId(userRequest.getUserId());
			            user.setFirstName(userRequest.getFirstName());
			            user.setLastName(userRequest.getLastName());
			            user.setType(userRequest.getType());
			            user.setEmail(userRequest.getEmail());
			            user.setPassword(userRequest.getPassword());
			            user.setCompany(userRequest.getCompany());
			            user.setDeleted(userRequest.isDeleted());
			            return user;
			        })
			        .collect(Collectors.toList());
	}


}

