package com.pritam.spring.ai.entity.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "user_type_master")
public class UserTypeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, columnDefinition = "BIGINT(20) UNSIGNED", insertable = false, updatable = false)
	private Long id;
	
	@Column(name = "utm_name", length = 20)
	private String name;
	
	@Column(name = "utm_description", length = 1000)
	private String description;

}
