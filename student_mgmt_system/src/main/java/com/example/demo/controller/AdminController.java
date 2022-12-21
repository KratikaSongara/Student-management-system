package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<User> registerAdmin(@RequestBody User admin) {
		return new ResponseEntity<>(userService.registerAdmin(admin), HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{adminId}/")
	public ResponseEntity<User> updateAdmin(@PathVariable Integer adminId, @RequestBody User admin) {
		return new ResponseEntity<>(userService.updateAdminDetails(adminId, admin), HttpStatus.ACCEPTED);
	}
	
}
