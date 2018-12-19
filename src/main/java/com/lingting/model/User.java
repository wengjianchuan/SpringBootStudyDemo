package com.lingting.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "t_user")
public class User {

	@Id
	@GeneratedValue(generator = "JDBC")
	private Integer userId;

	private String userName;

	@Column(name = "user_password")
	private String userPwd;

}
