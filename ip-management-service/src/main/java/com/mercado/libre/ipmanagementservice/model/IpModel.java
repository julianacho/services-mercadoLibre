package com.mercado.libre.ipmanagementservice.model;

/**
 * Modelo que se usa para el request del servicio validar Ip
 * 
 * @author Julian
 *
 */
public class IpModel {

	/**
	 * Ip a consultar
	 */
	private String ip;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
