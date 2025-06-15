package com.pritam.spring.ai.entity.user;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user_entity")
@Getter
@Setter
@ToString
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, columnDefinition = "BIGINT(20) UNSIGNED", insertable = false, updatable = false)
	private Long id;
	
	@Column(name = "ue_first_name", nullable = false, length = 100)
	private String firstName;
	
	@Column(name = "ue_last_name", length = 100)
	private String lastName;
	
	@Column(name = "ue_email", nullable = false, length = 50)
	private String email;
	
	@Column(name = "ue_mobile", length = 15)
	private String mobile;
	
	@Column(name = "ue_dob")
	private Date dateOfBirth;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_type_id", referencedColumnName = "id", nullable = false)
    private UserTypeEntity userType;
	
}
