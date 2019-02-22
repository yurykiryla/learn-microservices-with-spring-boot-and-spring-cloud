package com.itemsharing.userservice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itemsharing.userservice.model.User;
import com.itemsharing.userservice.repository.UserRepository;

@Service
public class UserServiceImpl implements com.itemsharing.userservice.service.UserService {
	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {
		return null;
	}

	@Override
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
