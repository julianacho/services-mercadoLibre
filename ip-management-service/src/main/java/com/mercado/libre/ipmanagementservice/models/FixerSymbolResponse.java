package com.mercado.libre.ipmanagementservice.models;

import java.util.Map;

/**
 * Modelo que contiene la información de los valores de monedas
 * 
 * @author Julian
 *
 */
public class FixerSymbolResponse {

	/**
	 * Fecha de la moneda
	 */
	private String date;
	/**
	 * Arreglo de monedas
	 */
	private Map<String, Object> rates;

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the rates
	 */
//	public List<FixerRateResponse> getRates() {
//		return rates;
//	}
	/**
	 * @param rates the rates to set
	 */

//	public void setRates(List<FixerRateResponse> rates) {
//		this.rates = rates;
//	}
	/**
	 * @return the rates
	 */
	public Map<String, Object> getRates() {
		return rates;
	}

	/**
	 * @param rates the rates to set
	 */
	public void setRates(Map<String, Object> rates) {
		this.rates = rates;
	}

}
