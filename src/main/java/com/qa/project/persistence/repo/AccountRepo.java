package com.qa.project.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.project.persistence.domain.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

	// bit after findBy MUST match a field in the entity
	Account findByUsername(String username);

}
