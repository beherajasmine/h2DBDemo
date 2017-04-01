package com.java.spring;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "USER")
public class User {
	
	private long id;
	private String name;
	private Set<Ticket> tickets;
	public User() {
		super();
	}
	public User(long id, String name, Set<Ticket> tickets) {
		super();
		this.id = id;
		this.name = name;
		this.tickets = tickets;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@OneToMany(mappedBy = "user")
	public Set<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}
}
