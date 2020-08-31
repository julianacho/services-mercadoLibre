package com.mercado.libre.ipmanagementservice.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.mercado.libre.ipmanagementservice.entity.Blacklist;
import com.mercado.libre.ipmanagementservice.models.IpResponse;
import com.mercado.libre.ipmanagementservice.service.BlacklistService;


@RestController // IMPLEMENTA COMO UN API RES
@RequestMapping("/api") // URL DEL END
public class BlackListController {
	
	@Autowired
	private BlacklistService blacklistService;
	
	@GetMapping("/find/{ip}")// Se envi el id por parametro @PathVariable
	@ResponseStatus(HttpStatus.OK)// Responde el estado de correcto aunque este se asigna por defecto
	public IpResponse find(@PathVariable String ip) {
		return this.blacklistService.findIp(ip);
	}
	
	// Tipo post recibe el objeto cliente por parametro
		@PostMapping("/register")// los datos bienen dentro de los datos de la peticion
		@ResponseStatus(HttpStatus.CREATED) // Responde el estatus de creado
		public Blacklist create(@RequestBody Blacklist blackList) {
			return blacklistService.register(blackList);			
		}

}
