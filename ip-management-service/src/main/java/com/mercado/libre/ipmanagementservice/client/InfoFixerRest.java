package com.mercado.libre.ipmanagementservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mercado.libre.ipmanagementservice.models.FixerSymbolResponse;


/**
 * Cliente al WS http://data.fixer.io/
 * @author Julian
 *
 */
@FeignClient(name = "service-info-fixer", url = "${fixer.search.uri}" )
public interface InfoFixerRest {
	
	/**
	 * Metodo get a servicio consulta de moneda a partir del código de la moneda
	 * @param accesKey: Codigo de acceso generado
	 * @param simbol: Simbolo de la moneda
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, consumes = "application/json" , 
			value = "api/latest?access_key={accesKey}&symbols={simbol}")
	public FixerSymbolResponse findInfoSimbol(@PathVariable String accesKey, @PathVariable String simbol);

}
