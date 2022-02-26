package com.tuto.service;

import java.util.List;

import com.tuto.model.User;

public interface UserService {

	User saveUser(User user);

	User updateUser(User user);

	void deleteUser(Long userId);

	User findByUsername(String username);

	List<User> findAllUsers();

	long numberOfUsers();

}
