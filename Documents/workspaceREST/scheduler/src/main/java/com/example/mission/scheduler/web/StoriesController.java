package com.example.mission.scheduler.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mission.scheduler.auth.domain.User;
import com.example.mission.scheduler.auth.service.UserService;
import com.example.mission.scheduler.domain.Stories;
import com.example.mission.scheduler.domain.Ticket;
import com.example.mission.scheduler.service.StoriesService;
import com.example.mission.scheduler.service.TicketService;


@RestController
public class StoriesController {
	
	
	TicketService ticketService;
	StoriesService storyService;
	UserService userService;
	
	
	@Autowired
	public StoriesController(StoriesService storyService, 
			TicketService ticketService, UserService userService){
		
		this.storyService = storyService;
		this.ticketService = ticketService;
		this.userService = userService;
	}
	
	@RequestMapping(value="/story/add/new",method=RequestMethod.POST)
	public void createStory(@RequestParam(value="userId",required=true) Long user_id){
		storyService.createStory(user_id);
	}
	
	//Need to add ticket to story getting JPA Error while retrieving story by id
	//resolve to create a new story with dummy ticket / add
	@RequestMapping(value="/story/{id}",method=RequestMethod.POST)
	public void addTicketToStory(@PathVariable Long id, @RequestParam(value="user_id", required=true) Long user_id,
			Ticket ticket){
		
		System.out.println("**hit story end point");
		User user = userService.getUserById(user_id);
		System.out.println("Got user object" + user.getEmail());
		Stories story;
		try{
		story = storyService.getStoryById(id);
		}catch(NullPointerException e){
			System.out.println("**** Throwing Null Exception ******");
			
		}
			
			System.out.println("*** Story is null ****");
			storyService.createStory(user_id);
			//Write null pointer exception if story does not exist...
			story = storyService.getStoryById(id);
		System.out.println(story.getId());
		//ticketService.addTicket(user, ticket);
		story.setTicket(new ArrayList<Ticket>(Arrays.asList(ticket)));
		
		storyService.save(story);
		
		
		
	}
	
	@RequestMapping(value="/story/get/all",method=RequestMethod.GET)
	public List<Stories> getStory(){
		
		List<Stories> stories = storyService.getAllStories();
		
		return stories;
	}
}
