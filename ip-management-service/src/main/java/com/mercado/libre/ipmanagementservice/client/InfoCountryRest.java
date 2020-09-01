package com.mercado.libre.ipmanagementservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mercado.libre.ipmanagementservice.models.CountryInfoResponse;

/**
 * Cliente al WS https://restcountries.eu/
 * @author Julian
 *
 */
@FeignClient(name = "service-info-country", url = "${country.search.uri}" )
public interface InfoCountryRest {
	
	/**
	 * Cliente get a servicio consulta de pais, a partir del código ISO
	 * @param cod
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, consumes = "application/json" , value = "rest/v2/alpha/{cod}")
	public CountryInfoResponse findCountryByCode(@PathVariable String cod);

}
