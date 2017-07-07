package com.example.mission.scheduler.auth.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.mission.scheduler.auth.domain.Roles;
import com.example.mission.scheduler.auth.domain.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private BCryptPasswordEncoder bPasswordEncoder;

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.findByEmailAddress(email);
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		final User usr = new User(); 
		usr.setFirstName(user.getFirstName());
		usr.setLastName(user.getLastName());
		usr.setActive(true);
		usr.setEmail(user.getEmail());
		usr.setPassword(bPasswordEncoder.encode(user.getPassword()));
		//usr.setRoles(user.getRoles());
		
		//All the users are now stored as admin role...
		//Role userRole = roleDao.findRole(user.getRole())
		//Give user option to set make them admin or not...
		//otherwise make them by default user...
		
		Roles userRole = roleDao.findByRole("admin");
		usr.setRoles(new HashSet<Roles>(Arrays.asList(userRole)));
		return userDao.save(usr);
	}

	@Override
	public User findAllActiveUsers() {
		// TODO Auto-generated method stub
		return userDao.findByActiveTrue();
	}

	@Override
	public List<User> findUserBylastName(String lastName) {
		// TODO Auto-generated method stub
		return userDao.findBylastName(lastName);
	}

	@Override
	public List<User> findUserByfirstName(String firstName) {
		// TODO Auto-generated method stub
		return userDao.findByfirstName(firstName);
	}
	
	public List<User> findAll(){
		
		return userDao.findAll();
	}

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return userDao.getOne(id);
	}
	
	
}
