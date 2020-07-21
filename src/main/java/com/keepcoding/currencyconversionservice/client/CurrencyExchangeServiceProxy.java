package com.keepcoding.currencyconversionservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.keepcoding.currencyconversionservice.model.CurrencyConversionBean;

@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
public interface CurrencyExchangeServiceProxy {
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	CurrencyConversionBean retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
}
