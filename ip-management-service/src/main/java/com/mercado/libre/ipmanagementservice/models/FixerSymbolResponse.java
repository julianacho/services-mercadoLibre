package com.mercado.libre.ipmanagementservice.models;

import java.util.List;
import java.util.Map;

public class FixerSymbolResponse {
	
	private String date;	
	private Map<String,Object> rates;
	// private FixerRateResponse[] rates;
	//private List<FixerRateResponse> rates;
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
