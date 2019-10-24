package com.capgemini.librarymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagement.beans.Users;
import com.capgemini.librarymanagement.service.AdminService;
import com.capgemini.librarymanagement.service.AdminServiceImpl;
import com.capgemini.librarymanagement.service.CommonService;
import com.capgemini.librarymanagement.util.UserResponse;
import com.mysql.fabric.Response;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AdminController {
	
	AdminService adminService = new AdminServiceImpl();
	
	@PostMapping("user/add")
	public UserResponse addLibrarian(@RequestBody Users user) {
		UserResponse response = new UserResponse();
		if(adminService.addLibrarian(user)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("User  successfully added");
			response.setUsers(user);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Failed to add");
		}
		return response;
	}
	
	@PutMapping("admin/updateLibrarian")
	public UserResponse updateLibrarian(@RequestBody Users librarian) {
		UserResponse response = new UserResponse();
		if(adminService.updateLibrarian(librarian)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Librarian successfully updated");
			response.setUsers(librarian);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Failed to update");
		}
		return response;
	}
	
	@DeleteMapping("user/delete/{userId}")
	public UserResponse deleteLibrarian(@PathVariable("userId") String userId ) {
		UserResponse response = new UserResponse();
		if(adminService.deleteLibrarian(userId)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Librarian deleted successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Failed to delete");
		}
		return response;
	}
	
	@GetMapping("user/search")
	public UserResponse searchLibrarian(@PathVariable("userId") String userId) {
		UserResponse response = new UserResponse();
		if(adminService.searchLibrarian(userId) != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Successfully searched librarian");	
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Failed to search");
		}
		return response;	
	}

	
	
	
	@GetMapping("user/showAllLibrarianInfo")
	public UserResponse showAllLibrarianInfo() {
		List<Users> admin = adminService.showAllLibrarianInfo();
		UserResponse response = new UserResponse();
		if(admin != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("All librarian information");
			response.setUsersList(admin);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("No librarian found");
		}
		return response;
	}
	
	@GetMapping("user/showAllStudentInfo")
	public UserResponse showAllStudentInfo() {
		List<Users> admin = adminService.showAllStudentInfo();
		UserResponse response = new UserResponse();
		if(admin != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("All student information");
			response.setUsersList(admin);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("No student found");
		}
		return response;
	}

}
