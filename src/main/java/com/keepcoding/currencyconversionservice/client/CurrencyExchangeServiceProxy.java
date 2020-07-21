package com.keepcoding.currencyconversionservice.client;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.keepcoding.currencyconversionservice.model.CurrencyConversionBean;

@FeignClient(name = "zuul-api-gateway-service")
@RibbonClient(name = "zuul-api-gateway-service")
public interface CurrencyExchangeServiceProxy {
	
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	CurrencyConversionBean retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
}
