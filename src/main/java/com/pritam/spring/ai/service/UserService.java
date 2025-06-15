package com.pritam.spring.ai.service;

import com.pritam.spring.ai.common.dto.GlobalResponse;
import com.pritam.spring.ai.dto.UserDto;

public interface UserService {

	GlobalResponse createUser(UserDto userDto);

}
