package com.example.mission.scheduler.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import com.example.mission.scheduler.auth.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="ticket")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Ticket implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	private String titleTicket;
	
	@Column(columnDefinition= "VARCHAR(2550)")
	private String description;
	
	
	@CreatedDate
	private Date dateTime;
	
	
	
	@Column(name="progress",updatable=true)
	private int progress;
	
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_ticket", joinColumns = @JoinColumn(name="ticket_id",
	referencedColumnName="id"),inverseJoinColumns=@JoinColumn(name="user_id",
	referencedColumnName="id"))
	private List<User> usersSubscribed = new ArrayList<User>();
	
	@OneToOne
    @JoinColumn(name = "user_id")
	private User ticketOwner;

	//private Stories belongsToStory;
	
	public Ticket(){}
	
	public Ticket(Long id, String titleTicket, String description,
			Date dateTime, int progress, List<User> usersSubscribed,
			User ticketOwner) {
		super();
		this.id = id;
		this.titleTicket = titleTicket;
		this.description = description;
		this.dateTime = dateTime;
		this.progress = progress;
		this.usersSubscribed = usersSubscribed;
		this.ticketOwner = ticketOwner;
		//this.belongsToStory = belongsToStory;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitleTicket() {
		return titleTicket;
	}

	public void setTitleTicket(String titleTicket) {
		this.titleTicket = titleTicket;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void addSubscribedUser(User user){
		usersSubscribed.add(user);
	}
	public void removeSubscribedUser(User user){
		usersSubscribed.remove(user);
	}
	
	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public List<User> getUsersSubscribed() {
		return usersSubscribed;
	}

	public void setUsersSubscribed(List<User> usersSubscribed) {
		this.usersSubscribed = usersSubscribed;
	}

	public User getTicketOwner() {
		return ticketOwner;
	}

	public void setTicketOwner(User ticketOwner) {
		this.ticketOwner = ticketOwner;
	}

/*	public Stories getBelongsToStory() {
		return belongsToStory;
	}

	public void setBelongsToStory(Stories belongsToStory) {
		this.belongsToStory = belongsToStory;
	}
	
	*/
	
}
