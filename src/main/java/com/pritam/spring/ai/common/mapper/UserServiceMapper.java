package com.pritam.spring.ai.common.mapper;

import org.mapstruct.Mapper;

import com.pritam.spring.ai.common.dto.UserTypeRq;
import com.pritam.spring.ai.entity.user.UserTypeEntity;

@Mapper(componentModel = "spring")
public interface UserServiceMapper {

	UserTypeEntity mapUserTypeRqToUserTypeEntity(UserTypeRq userTypeRq);

}
