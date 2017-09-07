package com.example.mission.scheduler.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.mission.scheduler.auth.domain.User;
import com.example.mission.scheduler.domain.Ticket;

@Service
public interface TicketService {

	Ticket findTicketBytitleTicket(String title);

	Ticket findTicketByProgress(int prog);

	Ticket findTicketByticketOwner(User ticketOwner);

	void addTicket(User user, Ticket ticket);

	List<Ticket> findAllTickets();

	Ticket getTicketById(Long id);

	void updateTicketSubscribers(Ticket ticket, User user);

	// List<User>getTicketSubscribers(Long id);
	List<User> getTicketSubscribers(Long id);

	void addTicketToStory(Ticket ticket, User user);
}
