package com.example.springjpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springjpa.model.UserRights;

/**
 * @author nageswara.eluri
 *
 */
@Repository
public interface UserRightsRepository extends JpaRepository<UserRights, Long> {

}
