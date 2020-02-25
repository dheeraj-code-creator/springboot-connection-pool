package com.springboot.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.rest.controller.UserController;
import com.springboot.rest.dto.UserDto;
import com.springboot.rest.entity.User;
import com.springboot.rest.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ConverterService converterService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	public List<UserDto> getAllUserInfo() {
		LOGGER.info("inside class!!!! UserService, method!!!: getAllUserInfo");
		List<User> userList = new ArrayList<>();
		User userObj1 = new User("111", "First Demo");
		User userObj2 = new User("222", "Second Demo");
		userList.add(userObj1);
		userList.add(userObj2);
		userRepository.saveAll(userList);
		List<User> userDataList = userRepository.findAll();
		return userDataList.stream().map(converterService::convertToDto).collect(Collectors.toList());
	}

	
	  public UserDto getUserByUserId(String userId) { 
		  LOGGER.info("method!!!: getUserByUserId", userId);
		  User userObj = userRepository.findById(userId).orElse(null);
		  return converterService.convertToDto(userObj);
	  }
	 
}

