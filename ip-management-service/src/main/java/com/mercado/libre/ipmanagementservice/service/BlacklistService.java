package com.mercado.libre.ipmanagementservice.service;

import org.springframework.http.ResponseEntity;

import com.mercado.libre.ipmanagementservice.entity.Blacklist;

/**
 * Fachada que expone las principales funciones de la API
 * 
 * @author Julian
 *
 */
public interface BlacklistService {

	/**
	 * Permite registrar una IP en una blacklist
	 * 
	 * @param blackList: Request de la peticion
	 * @return
	 */
	public ResponseEntity<Object> register(Blacklist blackList);

	/**
	 * Permite consultar una ip y de esta determinar el país al que pertenece ademas
	 * de indicar su moneda local.
	 * 
	 * @param ip
	 * @return
	 */
	public ResponseEntity<Object> findIp(String ip);

}
