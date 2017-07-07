package com.example.mission.scheduler.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.mission.scheduler.domain.Stories;

@Repository
public interface StoriesDao extends JpaRepository<Stories,Long> {
	
	
	List<Stories> findAll();
	//void addStories();
	

}
