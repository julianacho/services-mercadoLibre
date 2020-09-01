/**
 * 
 */
package com.mercado.libre.ipmanagementservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercado.libre.ipmanagementservice.entity.Blacklist;

/**
 * Interface que implementa el componente Repository de Spring para la
 * persistencia y consulta de una Ip en blackList
 * 
 * @author Julian
 *
 */
public interface BlacklistRepository extends JpaRepository<Blacklist, Integer> {

	/**
	 * Consulta una ip en la entidad Blacklist
	 * 
	 * @param ip
	 * @return
	 */
	List<Blacklist> findByIp(String ip);

}
