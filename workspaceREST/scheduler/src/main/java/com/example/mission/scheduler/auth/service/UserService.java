package com.example.mission.scheduler.auth.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.mission.scheduler.auth.domain.User;
@Service
public interface UserService {
	
	User findUserByEmail(String email);
	User addUser(User user);
	User findAllActiveUsers();
	List<User> findUserBylastName(String lastName);
	List<User> findUserByfirstName(String firstName);
	User getUserById(Long id);
}
