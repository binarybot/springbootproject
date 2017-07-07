package com.example.mission.scheduler.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.mission.scheduler.auth.domain.User;
import com.example.mission.scheduler.domain.Stories;
import com.example.mission.scheduler.domain.Ticket;

//Try to remove user object...

@Service
public interface StoriesService {

	void addTicketToStory(Ticket ticket, User user);
	void createStory(Long id);
	Stories getStoryById(Long id);
	void save(Stories story);
	List<Stories> getAllStories();
}
