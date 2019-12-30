package com.example.currencyexchangeservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.currencyexchangeservice.modal.ExchangeValue;

public interface CurrencyExchangeServiceRepository extends JpaRepository<ExchangeValue,Long>{
    public ExchangeValue findByFromAndTo(String from,String to);
}
