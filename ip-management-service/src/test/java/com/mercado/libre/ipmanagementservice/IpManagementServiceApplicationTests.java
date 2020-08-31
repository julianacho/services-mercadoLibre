package com.mercado.libre.ipmanagementservice;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mercado.libre.ipmanagementservice.entity.Blacklist;
import com.mercado.libre.ipmanagementservice.models.IpResponse;
import com.mercado.libre.ipmanagementservice.service.BlacklistService;
import com.mysql.cj.jdbc.ha.BalanceStrategy;


@SpringBootTest
class IpManagementServiceApplicationTests {
	
	final static String ip="3.23.22.138";
	
	@Autowired
	private BlacklistService blacklistService;

	@Test
	void testRegister() {
		Blacklist blackList=new Blacklist();
		blackList.setIp(ip);
		blackList.setCreateAt(new Date());
		ResponseEntity<Object> rta = blacklistService.register(blackList);
		assertTrue(rta.getStatusCode().equals(HttpStatus.CREATED));      
	}
	
	@Test
	void testFind() {		
		ResponseEntity<Object>  ipResponse = blacklistService.findIp(ip);
		assertTrue(ipResponse.getStatusCode().equals(HttpStatus.OK));       
	}

}
