package com.company.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.demohibernate.Repository.BankRepository;
import com.training.demohibernate.model.Bank;


@Service
public class BankServiceImpl implements BankService {

    private final BankRepository BankRepository;

    @Autowired
    public BankServiceImpl(BankRepository BankRepository) {
        this.BankRepository = BankRepository;
    }

    @Override
    public List<Bank> findAll() {
        return BankRepository.findAll();
    }

    @Override
    public Bank findById(Integer id) {
        return BankRepository.findById(id).orElse(null);
    }

    @Override
    public Bank save(Bank person) {
        return BankRepository.save(person);
    }

    @Override
    public void deleteById(Integer id) {
        BankRepository.deleteById(id);
    }
}