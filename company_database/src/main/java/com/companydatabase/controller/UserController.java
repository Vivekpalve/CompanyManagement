package com.companydatabase.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.companydatabase.exception.ResourceNotFoundException;
import com.companydatabase.request.UserRequest;
import com.companydatabase.response.UserResponse;
import com.companydatabase.service.UserService;



@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	   @GetMapping
	    public List<UserResponse> getAllUsers() {
	        return userService.getAllUsers();
	    }
	 
	   @GetMapping("/{userId}")
		public ResponseEntity<UserResponse> getUserById(@PathVariable Long userId) throws ResourceNotFoundException {
		    Optional<UserResponse> optionalUser = userService.getUsersById(userId);
		    if (optionalUser.isPresent()) {
		        return ResponseEntity.ok(optionalUser.get());
		    } else {
		        return ResponseEntity.notFound().build();
		    }
		}
	   
		@PutMapping("/update/{userId}")
		public String updateUser(@PathVariable Long userId, @RequestBody UserRequest userRequest) {
		    return userService.updateUser(userId, userRequest);
		}
		
		@PostMapping("/post")
		public UserResponse addUser(@RequestBody UserRequest userRequest) throws ResourceNotFoundException {
		    return userService.createUser(userRequest);
		}
		
		@DeleteMapping("/delete/{userId}")
		public String deleteUser(@PathVariable Long userId) throws ResourceNotFoundException {
		    return userService.deleteUser(userId);
		}
		
		@GetMapping("/user/{companyId}")
		public ResponseEntity<List<UserResponse>> getUsersByCompanyId(@PathVariable Long companyId) {
			List<UserResponse> users = userService.getUsersByCompanyId(companyId);
			if (users.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(users, HttpStatus.OK);
			}
		}
}
