package com.keepcoding.currencyconversionservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.keepcoding.currencyconversionservice.client.CurrencyExchangeServiceProxy;
import com.keepcoding.currencyconversionservice.model.CurrencyConversionBean;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	CurrencyExchangeServiceProxy currencyExchangeServiceProxy;
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable("from") String from, @PathVariable("to") String to, @PathVariable("quantity") BigDecimal quantity) {
		
		CurrencyConversionBean result = currencyExchangeServiceProxy.retrieveExchangeValue(from, to);
		
		return new CurrencyConversionBean(result.getId(), result.getFrom(), result.getTo(), result.getConversionMultiple(), quantity, quantity.multiply(result.getConversionMultiple()), 8100);
	}
}