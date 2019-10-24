package com.capgemini.librarymanagement.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.capgemini.busschedulingusingboot.beans.Bus;
import com.capgemini.busschedulingusingboot.utility.UserResponse;

public class StudentController {
	
	
	@GetMapping("/searchBus")
	public UserResponse SearchBus(Integer busId,ModelMap map) {
	
		UserResponse response=new UserResponse();
		try {
		Bus bus = busservice.searchBus(busId);
			if(bus!=null) {
				response.setStatusCode(201);
				response.setMessage("success");
				response.setBus(bus);
			}else {
				response.setStatusCode(404);
				response.setMessage("failed");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}return response;

	}//end of search owner


}
