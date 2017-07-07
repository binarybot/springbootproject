package com.example.mission.scheduler.auth.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.mission.scheduler.auth.domain.User;

@Repository
public interface UserDao extends JpaRepository<User,Long> {
		
		@Query("select u from User u where u.email like %:email%")
		User findByEmailAddress(@Param("email") String email);
		User findByActiveTrue();
		List<User> findBylastName(String lastName);
		List<User> findByfirstName(String firstName);
		List<User> findAll();
		//User findById(long id);
}
