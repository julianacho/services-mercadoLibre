package com.mercado.libre.ipmanagementservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mercado.libre.ipmanagementservice.models.IpServiceResponse;

/**
 * Cliente al WS https://api.ip2country.info/
 * @author Julian
 *
 */
@FeignClient(name = "service-country-ip", url ="${ipcountry.search.uri}")
public interface IpCountryRest {
	
	/**
	 * Metodo get que consula la ubicacíon de una IP.
	 * @param ip
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, consumes = "application/json" , value = "/ip?{ip}")
	public IpServiceResponse findCountry(@PathVariable String ip);

}
