package com.qa.project.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.project.persistence.domain.Account;
import com.qa.project.service.AccountService;

@RestController
public class AccountController {

	private AccountService service;
	
	public AccountController(AccountService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Account>> getAll(){
		return ResponseEntity.ok(this.service.getAll());
	}

	@PostMapping("/register")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		Account registeredAccount = this.service.register(account);
		return new ResponseEntity<Account>(registeredAccount, HttpStatus.CREATED);
	}
	
}
