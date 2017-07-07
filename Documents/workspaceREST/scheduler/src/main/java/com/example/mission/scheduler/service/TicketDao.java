package com.example.mission.scheduler.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mission.scheduler.auth.domain.User;
import com.example.mission.scheduler.domain.Ticket;

@Repository
public interface TicketDao extends JpaRepository<Ticket,Long> {
	
	 Ticket findBytitleTicket(String title);
	 Ticket findByProgress(int prog);
	 Ticket findByticketOwner(User ticketOwner);
	 List<Ticket>findAll();
}
