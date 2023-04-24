package com.companydatabase.successfullmessage;

import org.springframework.stereotype.Component;

@Component
public class MessageSuccessfull {

	
	public String dataUpdated(String name) {
		return name+" Data Updated Successfully";
	}

	public String dataDeleted(String name) {
		return name+" marked as deleted successfully";
	}
}
