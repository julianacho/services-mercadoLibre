package com.mercado.libre.ipmanagementservice.service;



import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.validator.routines.InetAddressValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mercado.libre.ipmanagementservice.client.InfoCountryRest;
import com.mercado.libre.ipmanagementservice.client.InfoFixerRest;
import com.mercado.libre.ipmanagementservice.client.IpCountryRest;
import com.mercado.libre.ipmanagementservice.dao.BlacklistRepository;
import com.mercado.libre.ipmanagementservice.entity.Blacklist;

import com.mercado.libre.ipmanagementservice.models.CountryInfoResponse;
import com.mercado.libre.ipmanagementservice.models.FixerSymbolResponse;
import com.mercado.libre.ipmanagementservice.models.IpResponse;
import com.mercado.libre.ipmanagementservice.models.IpServiceResponse;


@Service("blackListService")
@Transactional
public class BlacklistServiceImp implements BlacklistService {
	
	private static final String accesKey="4af31edcf77b46855a70abe1f8a2acc2";
	private static final  InetAddressValidator inetValidator = InetAddressValidator.getInstance();
	
	@Autowired
	BlacklistRepository blacklistRepository;
	
	@Autowired
	IpCountryRest ipCountryRest;
	
	@Autowired
	InfoCountryRest infoCountryRest;
	
	@Autowired
	InfoFixerRest infoFixerRest;

	@Override
	public ResponseEntity<Object> register(Blacklist blackList) {	
		try {
			
			if(!inetValidator.isValidInet4Address(blackList.getIp())) {
				return new ResponseEntity<>("Invalid Ip", HttpStatus.INTERNAL_SERVER_ERROR);
				
			}else {
				blackList.setCreateAt(new Date());
				return new ResponseEntity<>(blacklistRepository.save(blackList), HttpStatus.CREATED);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("Internal Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	   
	}

	@Override
	public ResponseEntity<Object> findIp(String ip) {
		try {
			if(!inetValidator.isValidInet4Address(ip)) {
				return new ResponseEntity<>("Invalid Ip", HttpStatus.INTERNAL_SERVER_ERROR);
				
			}else {
			List<Blacklist> blackListip=blacklistRepository.findByIp(ip);			
			if(blackListip==null || blackListip.isEmpty()) {
				IpResponse response=new IpResponse();				
				IpServiceResponse rtaIp=ipCountryRest.findCountry(ip);
				CountryInfoResponse rtaInfoCountry=infoCountryRest.findCountryByCode(rtaIp.getCountryCode());
				FixerSymbolResponse rta=infoFixerRest.findInfoSimbol(accesKey, rtaInfoCountry.getCurrencies().get(0).getCode());
							
				response.setCountryName(rtaIp.getCountryName());
				response.setCountryCode(rtaIp.getCountryCode());
				response.setCurrencyCountry(rtaInfoCountry.getCurrencies().get(0).getCode());
				response.setCurrencyName(rtaInfoCountry.getCurrencies().get(0).getName());
				response.setValueCurrencyEuro((Double)rta.getRates().get(rtaInfoCountry.getCurrencies().get(0).getCode()));
				return new ResponseEntity<>(response, HttpStatus.OK);
							
			}else {
				return new ResponseEntity<>("Ip  Error", HttpStatus.NON_AUTHORITATIVE_INFORMATION);
			}
			}
			
		} catch (Exception e) {			
			return new ResponseEntity<>("Internal Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
