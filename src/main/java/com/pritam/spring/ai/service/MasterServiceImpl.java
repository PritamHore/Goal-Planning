package com.pritam.spring.ai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pritam.spring.ai.common.dto.GlobalResponse;
import com.pritam.spring.ai.common.dto.UserTypeRq;
import com.pritam.spring.ai.common.mapper.UserServiceMapper;
import com.pritam.spring.ai.entity.user.UserTypeEntity;
import com.pritam.spring.ai.repository.UserTypeRepository;

@Service
public class MasterServiceImpl implements MasterService{
	
	@Autowired
	private UserTypeRepository userTypeRepository;
	@Autowired
	private UserServiceMapper userServiceMapper;

	@Override
	public GlobalResponse createUserType(UserTypeRq userTypeRq) {
		
		UserTypeEntity entity = userServiceMapper.mapUserTypeRqToUserTypeEntity(userTypeRq);
		
		Optional<UserTypeEntity> existingEntity = userTypeRepository.findByName(entity.getName());
		
		if (existingEntity.isPresent()) {
	        throw new IllegalArgumentException("User Type is already present in the system.");
	    }
		
		entity = userTypeRepository.save(entity);
		
		return new GlobalResponse(entity.getId(), "User Type Created Successfully.", Boolean.TRUE);
	}

}
