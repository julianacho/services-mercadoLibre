package com.mercado.libre.ipmanagementservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mercado.libre.ipmanagementservice.entity.Blacklist;

import com.mercado.libre.ipmanagementservice.service.BlacklistService;

/**
 * Controlador de peticiones Rest
 * 
 * @author Julian
 *
 */
@RestController
@RequestMapping("/api")
public class BlackListController {

	/**
	 * Servicio que posee la logica de la api
	 */
	@Autowired
	private BlacklistService blacklistService;

	/**
	 * Servicio Rest Tipo Get que consulta la ubicación e inforacion de la moneda de
	 * un país.
	 * 
	 * @param ip
	 * @return
	 */
	@GetMapping("/find/{ip}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> find(@PathVariable String ip) {
		return this.blacklistService.findIp(ip);
	}

	/**
	 * Servicio REST tipo Post que permite registrar un ip en blacklist
	 * 
	 * @param blackList
	 * @return
	 */
	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Object> create(@RequestBody Blacklist blackList) {
		return blacklistService.register(blackList);
	}

}
