package com.pritam.spring.ai.service;

import com.pritam.spring.ai.common.dto.GlobalResponse;
import com.pritam.spring.ai.common.dto.UserTypeRq;

public interface MasterService {

	GlobalResponse createUserType(UserTypeRq userTypeRq);

}
