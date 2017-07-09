package com.example.mission.scheduler.auth.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mission.scheduler.auth.domain.Roles;

@Repository
public interface RoleDao extends JpaRepository<Roles,Integer> {
	
	Roles findByRole(String role);

}
