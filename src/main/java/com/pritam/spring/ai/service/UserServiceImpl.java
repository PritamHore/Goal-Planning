package com.pritam.spring.ai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pritam.spring.ai.common.dto.GlobalResponse;
import com.pritam.spring.ai.common.exception.GlobalException;
import com.pritam.spring.ai.common.exception.ServiceStatus;
import com.pritam.spring.ai.common.mapper.UserServiceMapper;
import com.pritam.spring.ai.dto.UserDto;
import com.pritam.spring.ai.entity.user.UserEntity;
import com.pritam.spring.ai.entity.user.UserTypeEntity;
import com.pritam.spring.ai.repository.UserRepository;
import com.pritam.spring.ai.repository.UserTypeRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserTypeRepository userTypeRepository;
	
	@Autowired
	private UserServiceMapper userServiceMapper;

	@Override
	public GlobalResponse createUser(UserDto userDto) {
		
		Optional<UserEntity> existingCheck = userRepository.findByEmail(userDto.getEmail());
		if(existingCheck.isPresent()) {
			throw new GlobalException(ServiceStatus.E003.name(), new Object[] {userDto.getEmail()});
		}
		
		
		UserEntity userEntity = userServiceMapper.mapUserDtoToUserEntity(userDto);
		UserTypeEntity userType = userTypeRepository.findById(userDto.getUserTypeId())
				.orElseThrow(() -> new GlobalException(ServiceStatus.E002.name(),new Object[] {userDto.getUserTypeId()}));
		userEntity.setUserType(userType);
		userEntity = userRepository.save(userEntity);
		
		return new GlobalResponse(userEntity.getId(),"User Saved Successfully.", true);
	}

}
