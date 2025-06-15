package com.pritam.spring.ai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pritam.spring.ai.entity.user.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	Optional<UserEntity> findByEmail(String email);

}
