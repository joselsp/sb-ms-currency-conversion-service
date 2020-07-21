package com.keepcoding.currencyconversionservice.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.keepcoding.currencyconversionservice.model.CurrencyConversionBean;

@RestController
public class CurrencyConversionController {
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable("from") String from, @PathVariable("to") String to, @PathVariable("quantity") BigDecimal quantity) {
		return new CurrencyConversionBean(1L, from, to, BigDecimal.valueOf(1.0), BigDecimal.valueOf(1000.0), BigDecimal.valueOf(1000.0), 8100);
	}
}
