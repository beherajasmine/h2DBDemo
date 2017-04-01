package com.java.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private TicketRepository ticketRepo;
	
	@Transactional
	public String getName(long id){
		return userRepo.findNameById(id);
	}
	
	@Transactional
	public List<Ticket> getAllTickets(long id){
		return ticketRepo.findByUserId(id);
	}

}
