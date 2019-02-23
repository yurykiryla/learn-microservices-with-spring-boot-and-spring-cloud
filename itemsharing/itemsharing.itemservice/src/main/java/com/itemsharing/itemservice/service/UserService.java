package com.itemsharing.itemservice.service;

import com.itemsharing.itemservice.model.User;

public interface UserService {
	User getUserByUsername(String username);
}
