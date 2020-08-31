package com.mercado.libre.ipmanagementservice.service;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	private final String accesKey="4af31edcf77b46855a70abe1f8a2acc2";
	
	@Autowired
	BlacklistRepository blacklistRepository;
	
	@Autowired
	IpCountryRest ipCountryRest;
	
	@Autowired
	InfoCountryRest infoCountryRest;
	
	@Autowired
	InfoFixerRest infoFixerRest;

	@Override
	public Blacklist register(Blacklist blackList) {	
		return blacklistRepository.save(blackList);
	}

	@Override
	public IpResponse findIp(String ip) {
		try {
			List<Blacklist> blackListip=blacklistRepository.findByIp(ip);			
			if(blackListip==null || blackListip.isEmpty()) {
				IpResponse response=new IpResponse();				
				IpServiceResponse rtaIp=ipCountryRest.findCountry(ip);
				System.out.println(rtaIp.getCountryName());
				CountryInfoResponse rtaInfoCountry=infoCountryRest.findCountryByCode(rtaIp.getCountryCode());
				System.out.println(rtaInfoCountry.getCurrencies().toString());
				FixerSymbolResponse rta=infoFixerRest.findInfoSimbol(accesKey, rtaInfoCountry.getCurrencies().get(0).getCode());
				System.out.println(rta.getRates().toString());			
				
				response.setCountryName(rtaIp.getCountryName());
				response.setCountryCode(rtaIp.getCountryCode());
				response.setCurrencyCountry(rtaInfoCountry.getCurrencies().get(0).getCode());
				response.setCurrencyName(rtaInfoCountry.getCurrencies().get(0).getName());
				response.setValueCurrencyEuro((Double)rta.getRates().get(rtaInfoCountry.getCurrencies().get(0).getCode()));
				return response;
							
			}else {
				return null;
			}
			
		} catch (Exception e) {
			
			return null;
		}
		
	}

}
