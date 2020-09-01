package com.mercado.libre.ipmanagementservice.models;

/**
 * Modelo que contiene la respuesta de los posibles códigos de moneda.
 * 
 * @author Julian
 *
 */
public class CurrencieResponse {

	private String code;
	private String name;

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
