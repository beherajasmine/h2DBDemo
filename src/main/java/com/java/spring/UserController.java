package com.java.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/getUserNameJSON", method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User getNameJSON(@RequestBody User user){
		
		long id=user.getId();
		String uName=userService.getName(id);
		user.setName(uName);
		return user;
		
	}
	
	@RequestMapping(value="/getAllTicketsJSON", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Ticket> getAllTickets(@RequestParam("id") long id){		
		
		List<Ticket> tcks=userService.getAllTickets(id);
		return tcks;
		
	}
	
	@RequestMapping(value="/test")
	public String test(){
		return "success";
	}

}
