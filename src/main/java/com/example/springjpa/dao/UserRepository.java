package com.example.springjpa.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springjpa.model.User;

/**
 * @author nageswara.eluri
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
}
