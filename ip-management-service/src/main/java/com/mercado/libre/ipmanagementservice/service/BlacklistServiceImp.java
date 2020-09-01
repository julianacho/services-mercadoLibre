package com.mercado.libre.ipmanagementservice.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.validator.routines.InetAddressValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mercado.libre.ipmanagementservice.cache.CountryCache;
import com.mercado.libre.ipmanagementservice.client.InfoCountryRest;
import com.mercado.libre.ipmanagementservice.client.InfoFixerRest;
import com.mercado.libre.ipmanagementservice.client.IpCountryRest;
import com.mercado.libre.ipmanagementservice.dao.BlacklistRepository;
import com.mercado.libre.ipmanagementservice.entity.Blacklist;

import com.mercado.libre.ipmanagementservice.models.CountryInfoResponse;
import com.mercado.libre.ipmanagementservice.models.FixerSymbolResponse;
import com.mercado.libre.ipmanagementservice.models.IpResponse;
import com.mercado.libre.ipmanagementservice.models.IpServiceResponse;

/**
 * Implementacion del servicio de los metodos de la api
 * 
 * @author Julian
 *
 */
@Service("blackListService")
@Transactional
public class BlacklistServiceImp implements BlacklistService {

	/**
	 * Codigo de acceso para el cliente fixer
	 */
	@Value("${fixer.accesKey}")
	private String accesKey;

	/**
	 * Instancia que permite realizar la validacion de la ip
	 */
	private static final InetAddressValidator inetValidator = InetAddressValidator.getInstance();

	/**
	 * Servicio del repositorio de la blacklist
	 */
	@Autowired
	BlacklistRepository blacklistRepository;

	/**
	 * Servicio Cliente para consulta de la ip
	 */
	@Autowired
	IpCountryRest ipCountryRest;

	/**
	 * Servicio Cliente para obtener información de un pais
	 */
	@Autowired
	InfoCountryRest infoCountryRest;

	/**
	 * Servicio Cliente que consulta las monedas de un pais
	 */
	@Autowired
	InfoFixerRest infoFixerRest;

	/**
	 * Servicio de cache, para optimizar los llamados a las API
	 */
	@Autowired
	private transient CountryCache cache;

	@Override
	public ResponseEntity<Object> register(Blacklist blackList) {
		try {

			if (!inetValidator.isValidInet4Address(blackList.getIp())) {
				return new ResponseEntity<>("Invalid Ip", HttpStatus.INTERNAL_SERVER_ERROR);

			} else {
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
			if (!inetValidator.isValidInet4Address(ip)) {
				return new ResponseEntity<>("Invalid Ip", HttpStatus.INTERNAL_SERVER_ERROR);

			} else {
				List<Blacklist> blackListip = blacklistRepository.findByIp(ip);
				if (blackListip == null || blackListip.isEmpty()) {
					IpResponse response = new IpResponse();
					IpServiceResponse rtaIp = ipCountryRest.findCountry(ip);
					// Se valida en la cache de paises
					if (cache.getMap().get(rtaIp.getCountryCode()) != null) {
						return new ResponseEntity<>(cache.getMap().get(rtaIp.getCountryCode()), HttpStatus.OK);
					}

					CountryInfoResponse rtaInfoCountry = infoCountryRest.findCountryByCode(rtaIp.getCountryCode());
					FixerSymbolResponse rta = infoFixerRest.findInfoSimbol(accesKey,
							rtaInfoCountry.getCurrencies().get(0).getCode());

					response.setCountryName(rtaIp.getCountryName());
					response.setCountryCode(rtaIp.getCountryCode());
					response.setCurrencyCountry(rtaInfoCountry.getCurrencies().get(0).getCode());
					response.setCurrencyName(rtaInfoCountry.getCurrencies().get(0).getName());
					response.setValueCurrencyEuro(
							(Double) rta.getRates().get(rtaInfoCountry.getCurrencies().get(0).getCode()));
					// Se registra en cache de paises
					cache.getMap().put(response.getCountryCode(), response);
					return new ResponseEntity<>(response, HttpStatus.OK);

				} else {
					return new ResponseEntity<>("Ip Report in Ban/Blacklist", HttpStatus.NON_AUTHORITATIVE_INFORMATION);
				}
			}

		} catch (Exception e) {
			return new ResponseEntity<>("Internal Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
