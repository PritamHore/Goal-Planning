package com.pritam.spring.ai.common.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.pritam.spring.ai.common.dto.UserTypeRq;
import com.pritam.spring.ai.dto.UserDto;
import com.pritam.spring.ai.entity.user.UserEntity;
import com.pritam.spring.ai.entity.user.UserTypeEntity;

@Mapper(componentModel = "spring")
public interface UserServiceMapper {

	UserTypeEntity mapUserTypeRqToUserTypeEntity(UserTypeRq userTypeRq);
	
	@Mapping(target = "userType", ignore = true)
	UserEntity mapUserDtoToUserEntity(UserDto userDto);

}
