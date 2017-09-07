package com.example.mission.scheduler.web;

import static org.assertj.core.api.Assertions.useRepresentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mission.scheduler.auth.domain.User;
import com.example.mission.scheduler.auth.service.UserService;
import com.example.mission.scheduler.domain.Ticket;
import com.example.mission.scheduler.service.TicketService;


@RestController
public class TicketController {

	
	
	
	private TicketService ticketService;
	private UserService userService;

	@Autowired
	public TicketController(TicketService ticketService, UserService userService){
		this.ticketService = ticketService;
		this.userService = userService;
	}
	
	//adding user id to path to add ticket...need to get the 
	//user object after login and remove id from path...
	@RequestMapping(value="/ticket/{id}/add",method=RequestMethod.POST)
	public void addTicket(@PathVariable Long id,Ticket ticket){
		User user = userService.getUserById(id);
		ticketService.addTicket(user,ticket);
	}
	
	@RequestMapping(value="/ticket/get/{id}",method=RequestMethod.GET)
	public Ticket getTicketById(@PathVariable Long id){
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		Ticket ticket = ticketService.getTicketById(id);
		return ticket;
	}
	
	@RequestMapping(value="/ticket/all",method=RequestMethod.GET)
	public List<Ticket> getAll(){
		
		return (List<Ticket>) ticketService.findAllTickets();
	}
	
	@RequestMapping(value="/ticket/{ticket_id}/user/{user_id}",method=RequestMethod.POST)
	public void subscribeUserToTicket(@PathVariable Long user_id,@PathVariable long ticket_id,
			@RequestParam(value="subscribed", required=true) boolean subscribed){
		
		User user = userService.getUserById(user_id);
		Ticket ticket = ticketService.getTicketById(ticket_id);
		
		if(subscribed){
			System.out.println("subscribe = true");
			ticketService.updateTicketSubscribers(ticket, user);
			
		}else{
			System.out.println("******* Not adding subscriber *******");
		}
		//return ticket;
	}
	
	@RequestMapping(value="/ticket/{id}/subscribers",method=RequestMethod.GET)
	public List<User> getTicketSubscribedByUsers(@PathVariable Long id){
		
		return ((TicketService) ticketService).getTicketSubscribers(id);
		
	}
}
