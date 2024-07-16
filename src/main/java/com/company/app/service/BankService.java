package com.company.app.service;

import java.util.List;

import com.training.demohibernate.model.Bank;

public interface BankService {
    List<Bank> findAll();
    Bank findById(Integer id);
    Bank save(Bank bank);
	void deleteById(Integer id);
}