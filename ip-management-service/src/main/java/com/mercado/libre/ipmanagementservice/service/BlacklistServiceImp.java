package com.mercado.libre.ipmanagementservice.service;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercado.libre.ipmanagementservice.dao.BlacklistRepository;
import com.mercado.libre.ipmanagementservice.entity.Blacklist;


@Service("empleadoService")
@Transactional
public class BlacklistServiceImp implements BlacklistService {
	
	@Autowired
	BlacklistRepository blacklistRepository;

	@Override
	public Blacklist register(Blacklist blackList) {	
		return blacklistRepository.save(blackList);
	}

	@Override
	public List<Blacklist> findIp(String ip) {
		return blacklistRepository.findByIp(ip);
	}

}
