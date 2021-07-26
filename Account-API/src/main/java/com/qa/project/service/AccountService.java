package com.qa.project.service;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.qa.project.persistence.domain.Account;
import com.qa.project.persistence.repo.AccountRepo;

@Service
public class AccountService {
	
	private AccountRepo repo;
	
	private RestTemplate rest;
	
//	private NumberGenService numberGen;
	
//	private PrizeGenService prizeGen;
	
	public AccountService(AccountRepo repo, RestTemplateBuilder builder) {
	super();
	this.repo = repo;
	this.rest = builder.build();
}
	
//	public AccountService(AccountRepo repo, RestTemplateBuilder builder, PrizeGenService prizeGen) {
//		super();
//		this.repo = repo;
//		this.rest = builder.build();
//		this.prizeGen = prizeGen;
//	}

//	public AccountService(AccountRepo repo, NumberGenService numberGen, PrizeGenService prizeGen) {
//		super();
//		this.repo = repo;
//		this.numberGen = numberGen;
//		this.prizeGen = prizeGen;
//	}
	
	public Account register(Account account) {
//		Account number generated through numberGen service
//		String accNumber = numberGen.genNumber();
// 		Account account number set with acc number
//		account.setAccountNumber(accNumber);
		
		String accNumber = this.rest.getForObject("http://localhost:8082/genNum", String.class);
		account.setAccountNumber(accNumber);
		
//		Integer prize = this.prizeGen.genPrize(accNumber);
//		account.setPrize(prize);
		
		String prizeString = this.rest.getForObject("http://localhost:8083/genPrize/" + accNumber, String.class);
		Integer prize = Integer.parseInt(prizeString);
		account.setPrize(prize);
		
		Account registeredAccount = this.repo.save(account);
		return registeredAccount;
	}

	public List<Account> getAll() {
		return this.repo.findAll();
	}

}
