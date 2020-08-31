package com.mercado.libre.ipmanagementservice.service;





import com.mercado.libre.ipmanagementservice.entity.Blacklist;
import com.mercado.libre.ipmanagementservice.models.IpResponse;

public interface BlacklistService {
	
	public Blacklist register(Blacklist blackList);
	
	public IpResponse findIp(String ip);

}
