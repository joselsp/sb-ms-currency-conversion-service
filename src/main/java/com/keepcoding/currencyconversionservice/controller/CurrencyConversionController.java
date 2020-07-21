package com.keepcoding.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.keepcoding.currencyconversionservice.model.CurrencyConversionBean;

@RestController
public class CurrencyConversionController {
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable("from") String from, @PathVariable("to") String to, @PathVariable("quantity") BigDecimal quantity) {
		
		Map<String, String> uriVars = new HashMap<>();
		uriVars.put("from", from);
		uriVars.put("to", to);
		
		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, uriVars);
		CurrencyConversionBean result = responseEntity.getBody();
		
		return new CurrencyConversionBean(result.getId(), result.getFrom(), result.getTo(), result.getConversionMultiple(), quantity, quantity.multiply(result.getConversionMultiple()), 8100);
	}
}
