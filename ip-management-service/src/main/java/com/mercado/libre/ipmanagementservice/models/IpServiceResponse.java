package com.mercado.libre.ipmanagementservice.models;

/**
 * Modelo que indica la respuesta del servicio de consulta de IP
 * 
 * @author Julian
 *
 */
public class IpServiceResponse {

	/**
	 * Indica el país al que pertenece la IP
	 */
	private String countryCode;
	/**
	 * Indica el nombre del pais
	 */
	private String countryName;

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

}
