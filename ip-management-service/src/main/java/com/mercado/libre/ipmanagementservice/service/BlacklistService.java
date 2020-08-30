package com.mercado.libre.ipmanagementservice.service;



import java.util.List;

import com.mercado.libre.ipmanagementservice.entity.Blacklist;

public interface BlacklistService {
	
	public Blacklist register(Blacklist blackList);
	
	public List<Blacklist> findIp(String ip);

}
