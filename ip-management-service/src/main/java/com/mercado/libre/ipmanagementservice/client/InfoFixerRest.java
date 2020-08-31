package com.mercado.libre.ipmanagementservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mercado.libre.ipmanagementservice.models.FixerSymbolResponse;


@FeignClient(name = "service-info-fixer", url = "http://data.fixer.io/" )
public interface InfoFixerRest {
	
	@RequestMapping(method = RequestMethod.GET, consumes = "application/json" , 
			value = "api/latest?access_key={accesKey}&symbols={simbol}")
	public FixerSymbolResponse findInfoSimbol(@PathVariable String accesKey, @PathVariable String simbol);

}
