package com.springboot.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto {

	//@JsonIgnore  if you don't want to show in response.
	@JsonProperty(value="userId")
	private String userId=null;
	
	@JsonProperty(value="userName")
	private String userName=null;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
