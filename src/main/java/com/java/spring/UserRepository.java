package com.java.spring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT u.name FROM User u where u.id = :id") 
    String findNameById(@Param("id") long id);

}
