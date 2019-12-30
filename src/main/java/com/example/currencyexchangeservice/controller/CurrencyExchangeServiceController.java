package com.example.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.currencyexchangeservice.modal.ExchangeValue;
import com.example.currencyexchangeservice.repo.CurrencyExchangeServiceRepository;

@RestController
public class CurrencyExchangeServiceController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeServiceRepository exchangeRepository;
	
	@GetMapping("/currency/exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue = exchangeRepository.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeValue;
	}

	
}
