package com.java.spring;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TICKET")
public class Ticket {
	
	private long id;
	private User user;
	
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ticket(long ticketId, User user) {
		super();
		this.id = ticketId;
		this.user = user;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public long getTicketId() {
		return id;
	}
	public void setTicketId(long ticketId) {
		this.id = ticketId;
	}
	@ManyToOne
	@JoinColumn(name = "user_Id")
	@JsonIgnore
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
