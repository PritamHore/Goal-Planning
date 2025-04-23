package com.pritam.spring.ai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pritam.spring.ai.common.dto.GlobalResponse;
import com.pritam.spring.ai.common.dto.UserTypeRq;
import com.pritam.spring.ai.service.MasterService;


@RestController
@RequestMapping("/api/v1/master")
public class MasterController {
	
	@Autowired
	private MasterService masterService;
	
	@PostMapping("/user-type/create")
	public ResponseEntity<GlobalResponse> createUserType(@RequestBody UserTypeRq userTypeRq){
		
		return ResponseEntity.ok( masterService.createUserType(userTypeRq));
		
	}

}
