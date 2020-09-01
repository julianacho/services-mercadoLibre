package com.mercado.libre.ipmanagementservice.models;

/**
 * Modelo que posee la respuesta del servicio de consulta de Ip
 * 
 * @author Julian
 *
 */
public class IpResponse {

	/**
	 * Indica el nombre del pais al que pertenece la IP
	 */
	private String countryName;
	/**
	 * indica el código ISO del país
	 */
	private String countryCode;
	/**
	 * Indica el código de la moneda
	 */
	private String currencyCountry;
	/**
	 * Indica el nombre de la moneda
	 */
	private String currencyName;
	/**
	 * Indica el valor de la moneda en Euros
	 */
	private double valueCurrencyEuro;

	public IpResponse() {
		super();

	}

	/**
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @return the currencyCountry
	 */
	public String getCurrencyCountry() {
		return currencyCountry;
	}

	/**
	 * @param currencyCountry the currencyCountry to set
	 */
	public void setCurrencyCountry(String currencyCountry) {
		this.currencyCountry = currencyCountry;
	}

	/**
	 * @return the valueCurrencyEuro
	 */
	public double getValueCurrencyEuro() {
		return valueCurrencyEuro;
	}

	/**
	 * @param valueCurrencyEuro the valueCurrencyEuro to set
	 */
	public void setValueCurrencyEuro(double valueCurrencyEuro) {
		this.valueCurrencyEuro = valueCurrencyEuro;
	}

	/**
	 * @return the currencyName
	 */
	public String getCurrencyName() {
		return currencyName;
	}

	/**
	 * @param currencyName the currencyName to set
	 */
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

}
