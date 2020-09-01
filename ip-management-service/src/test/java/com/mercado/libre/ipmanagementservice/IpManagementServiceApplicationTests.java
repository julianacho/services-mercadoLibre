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
	
	final static String ipRegisterBad="3.23";
	final static String ipRegister="3.23.22.228";
	final static String ipFind="3.23.22.139";
	
	@Autowired
	private BlacklistService blacklistService;

	@Test
	void testRegisterOk() {
		Blacklist blackList=new Blacklist();
		blackList.setIp(ipRegister);
		blackList.setCreateAt(new Date());
		ResponseEntity<Object> rta = blacklistService.register(blackList);
		assertTrue(rta.getStatusCode().equals(HttpStatus.CREATED));      
	}
	
	@Test
	void testRegisterBadIp() {
		Blacklist blackList=new Blacklist();
		blackList.setIp(ipRegisterBad);
		blackList.setCreateAt(new Date());
		ResponseEntity<Object> rta = blacklistService.register(blackList);
		assertTrue(rta.getStatusCode().equals(HttpStatus.INTERNAL_SERVER_ERROR));      
	}
	
	@Test
	void testFindIpOk() {		
		ResponseEntity<Object>  ipResponse = blacklistService.findIp(ipFind);
		assertTrue(ipResponse.getStatusCode().equals(HttpStatus.OK));       
	}
	
	@Test
	void testFindIpReportInBlackList() {		
		ResponseEntity<Object>  ipResponse = blacklistService.findIp(ipRegister);
		assertTrue(ipResponse.getStatusCode().equals(HttpStatus.NON_AUTHORITATIVE_INFORMATION));       
	}
	
	@Test
	void testFindBadIp() {		
		ResponseEntity<Object>  ipResponse = blacklistService.findIp(ipRegisterBad);
		assertTrue(ipResponse.getStatusCode().equals(HttpStatus.INTERNAL_SERVER_ERROR));       
	}

}
