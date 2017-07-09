package com.example.mission.scheduler.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mission.scheduler.auth.domain.User;
import com.example.mission.scheduler.auth.service.UserDao;
import com.example.mission.scheduler.service.StoriesService;
import com.example.mission.scheduler.domain.Ticket;

@Service
public class TicketServiceImpl implements TicketService {

	
	TicketDao ticketDao;
	UserDao userDao;
	StoriesService storyService;
	
	@Autowired
	public TicketServiceImpl(TicketDao ticketDao,UserDao userDao,StoriesService storyService){
		this.ticketDao = ticketDao;
		this.userDao = userDao;
		this.storyService = storyService;
	}

	@Override
	public Ticket findTicketBytitleTicket(String title) {
		// TODO Auto-generated method stub
		
		return ticketDao.findBytitleTicket(title);
		
		
	}

	@Override
	public Ticket findTicketByProgress(int prog) {
		// TODO Auto-generated method stub
		return ticketDao.findByProgress(prog);
	}

	@Override
	public Ticket findTicketByticketOwner(User ticketOwner) {
		// TODO Auto-generated method stub
		return ticketDao.findByticketOwner(ticketOwner);
	}

	@Override
	public void addTicket(User user,Ticket ticket) {
		// TODO Auto-generated method stub
		Ticket tick = new Ticket(); 
		//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		System.out.println("**************?>>>>>This is within the user.getId()");

		tick.setDateTime(date);
		tick.setDescription(ticket.getDescription());
		tick.setProgress(100);
		tick.setTicketOwner(user);
		tick.setTitleTicket(ticket.getTitleTicket());
		System.out.println("Ticket description \t"+ticket.getDescription());
		
		/*if(!ticket.getTicketOwner().equals(null)){
		tick.setTicketOwner(ticket.getTicketOwner());
		}else{
			
			System.out.println("This is within the user.getId()");
			
		}*/
		ticketDao.save(tick);
		
		//Adding ticket to the story....Don't use this...
		//need to modify this or delete the below line...
		//storyService.addTicketToStory(ticket,user);
	}

	@Override
	public List<Ticket> findAllTickets() {
		// TODO Auto-generated method stub
		return ticketDao.findAll();
	}

	@Override
	public Ticket getTicketById(Long id) {
		// TODO Auto-generated method stub
		return ticketDao.getOne(id);
	}

	public void updateTicketSubscribers(Ticket ticket, User user){
		Ticket tc = ticketDao.findOne(ticket.getId());
		tc.addSubscribedUser(user);
		ticketDao.save(tc);
	}

	@Override
	public List<User> getTicketSubscribers(Long id) {
		// TODO Auto-generated method stub
		Ticket ticket = new Ticket();
		ticket = ticketDao.getOne(id);
		return ticket.getUsersSubscribed();
	}
	
	//The below function is not to be used... Just a dummy function 
	//need to modify so that tickets can be added into backlog...rather
	//than story service 
	@Override
	public void addTicketToStory(Ticket ticket, User user){
		storyService.addTicketToStory(ticket,user);
	}
	
}
