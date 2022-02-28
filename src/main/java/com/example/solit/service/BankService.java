package com.example.solit.service;

import com.devcolibri.dataexam.entity.Bank;

import java.util.List;
//В этом интерфейс мы указали, какие методы нам будут нужны для написания
//бизнес-логики проект

public interface BankService {

    Bank addBank(Bank bank);
    void delete(long id);
    Bank getByName(String name);
    Bank editBank(Bank bank);
    List<Bank> getAll();

}
