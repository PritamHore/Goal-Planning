package com.pritam.spring.ai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pritam.spring.ai.common.dto.GlobalResponse;
import com.pritam.spring.ai.dto.UserDto;
import com.pritam.spring.ai.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/create")
	public ResponseEntity<GlobalResponse> createUser(@RequestBody UserDto userDto){
		
		return ResponseEntity.ok(userService.createUser(userDto));
	}
	
	
}
