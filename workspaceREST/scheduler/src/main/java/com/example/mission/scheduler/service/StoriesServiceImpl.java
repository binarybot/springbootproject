package com.example.mission.scheduler.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mission.scheduler.auth.domain.User;
import com.example.mission.scheduler.auth.service.UserService;
import com.example.mission.scheduler.domain.Stories;
import com.example.mission.scheduler.domain.Ticket;

@Service
public class StoriesServiceImpl implements StoriesService{
	
	@Autowired
	StoriesDao storyDao;
	
	@Autowired
	TicketService ticketService;
	
	@Autowired
	UserService userService;
	
	//The below function creates a new ticket and add it to ticket and 
	//stories entity in the database....
	@Override
	public void addTicketToStory(Ticket ticket, User user) {
		// TODO Auto-generated method stub
		//Ticket tick = new Ticket();
		
		System.out.println("Adding ticket to story");
		ticketService.addTicket(user, ticket);
		
		//Stories story ;//= getStoryById();
		//story.setStoryOwner(storyOwner);
		
		//story.addTicketToStory(ticket);
		//storyDao.save(story);
		
		System.out.println("Getting count in story"+storyDao.count());
		
	}

	//need to remove user object based upon sessions...
	@Override
	public void createStory(Long id) {
		// TODO Auto-generated method stub
		//time when story was created and pass time into the ticket...
		User storyOwner = userService.getUserById(id); 
		Stories story = new Stories();
		story.setTicket(new ArrayList<>(Arrays.asList(new Ticket())));
		story.setStoryOwner(storyOwner);
		storyDao.save(story);
		
	}

	@Override
	public Stories getStoryById(Long id) {
		// TODO Auto-generated method stub
		System.out.println("***Getting story by id");
		try{
		Stories st=	storyDao.findOne(id);
		return st;
		}catch(NullPointerException e){
			System.out.println("null");
		}
		return null;
	}

	@Override
	public void save(Stories story) {
		// TODO Auto-generated method stub
		
		storyDao.save(story);
	}

	@Override
	public List<Stories> getAllStories() {
		// TODO Auto-generated method stub
		List<Stories>stList = storyDao.findAll();
		for(Stories s : stList){
			System.out.println(s);
		}
		return stList;
	}
	
	
}
