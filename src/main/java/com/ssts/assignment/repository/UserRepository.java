/**
 * 
 */
package com.ssts.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssts.assignment.model.User;

/**
 * @author seetha
 *
 */

public interface UserRepository extends JpaRepository<User, Long> {
	

}
