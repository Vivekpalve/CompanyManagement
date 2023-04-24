package com.companydatabase.transformer;

import com.companydatabase.entity.Users;
import com.companydatabase.response.UserResponse;

public class UserResponseConverter {

	 public static UserResponse convertToResponse(Users user) {
		 UserResponse userResponse = new UserResponse();
		 userResponse.setUserId(user.getUserId());
		 userResponse.setFirstName(user.getFirstName());
		 userResponse.setLastName(user.getLastName());
		 userResponse.setType(user.getType()); 
		 userResponse.setEmail(user.getEmail()); 
		 userResponse.setPassword(user.getPassword()); 
		 userResponse.setCompany(user.getCompany());
		 userResponse.setDeleted(user.getCompany().getIsDeleted());
		 userResponse.setCompanyId(user.getCompany().getCompanyId());
	        return userResponse;
	    }
}
