/**
 * 
 */
package com.mercado.libre.ipmanagementservice.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.mercado.libre.ipmanagementservice.entity.Blacklist;




/**
 * @author Julian
 *
 */
public interface BlacklistRepository extends JpaRepository<Blacklist,Integer> {
	
	List<Blacklist> findByIp(String ip);

}
