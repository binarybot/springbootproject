/*package com.example.mission.scheduler.domain;

import java.util.List;

import javax.persistence.OneToMany;

import com.example.mission.scheduler.auth.domain.User;

public class UserAssociation extends User {
	
	@OneToMany(mappedBy="user")
	private List<TicketAssociation> userTickets;
	
	public UserAssociation(){}

	public UserAssociation(List<TicketAssociation> userTickets) {
		super();
		this.userTickets = userTickets;
	}

	public List<TicketAssociation> getUserTickets() {
		return userTickets;
	}

	public void setUserTickets(List<TicketAssociation> userTickets) {
		this.userTickets = userTickets;
	}
	

}*/
