package com.mercado.libre.ipmanagementservice.service;





import org.springframework.http.ResponseEntity;

import com.mercado.libre.ipmanagementservice.entity.Blacklist;


public interface BlacklistService {
	
	public ResponseEntity<Object> register(Blacklist blackList);
	
	public ResponseEntity<Object> findIp(String ip);

}
