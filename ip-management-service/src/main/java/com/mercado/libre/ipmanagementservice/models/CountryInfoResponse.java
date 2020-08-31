package com.mercado.libre.ipmanagementservice.models;

import java.util.List;

public class CountryInfoResponse {
	
	List<CurrencieResponse> currencies;

	/**
	 * @return the currencies
	 */
	public List<CurrencieResponse> getCurrencies() {
		return currencies;
	}

	/**
	 * @param currencies the currencies to set
	 */
	public void setCurrencies(List<CurrencieResponse> currencies) {
		this.currencies = currencies;
	}

}
