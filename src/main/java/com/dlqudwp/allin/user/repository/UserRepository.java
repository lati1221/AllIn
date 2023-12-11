package com.dlqudwp.allin.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dlqudwp.allin.user.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
    Optional<User> findByLoginId(String loginId);

	
	public int countByLoginId(String loginId);
	

}
