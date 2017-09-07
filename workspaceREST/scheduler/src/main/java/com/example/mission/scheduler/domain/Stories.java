package com.example.mission.scheduler.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Id;

import com.example.mission.scheduler.auth.domain.User;

@Entity
@Table(name="stories")
public class Stories {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	
	@OneToMany(mappedBy="belongToStory")
	private List<Ticket> ticket;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User storyOwner;
	
	public Stories(){}

	public Stories(Long id, List<Ticket> ticket, User storyOwner) {
		super();
		Id = id;
		this.ticket = ticket;
		this.storyOwner = storyOwner;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public List<Ticket> getTicket() {
		return ticket;
	}

	public void setTicket(List<Ticket> ticket) {
		this.ticket = ticket;
	}
	
	public void addTicket(Ticket tick){
		ticket.add(tick);
	}
	
	public void removeTicketFromStory(Ticket tick){
		ticket.remove(tick);
	}

	public User getStoryOwner() {
		return storyOwner;
	}

	public void setStoryOwner(User storyOwner) {
		this.storyOwner = storyOwner;
	}
	
	
	
}
