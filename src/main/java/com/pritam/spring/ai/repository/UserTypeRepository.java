package com.pritam.spring.ai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pritam.spring.ai.entity.user.UserTypeEntity;

@Repository
public interface UserTypeRepository extends JpaRepository<UserTypeEntity, Long> {

	Optional<UserTypeEntity> findByName(String name);

}
