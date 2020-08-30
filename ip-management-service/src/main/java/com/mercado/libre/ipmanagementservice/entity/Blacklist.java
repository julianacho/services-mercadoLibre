package com.mercado.libre.ipmanagementservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity that owns maps the table BLACK_lIST
 * @author Julian
 *
 */

@Entity
@Table(name="BLACK_lIST",schema="mercadolibre")
public class Blacklist {
	
	
	/**
	 * Id table BLACK_lIST is a secuence
	 */
	@Id
	@Column(name="black_list_id")	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * Ip register into black list
	 */
	@Column(name="black_list_ip")
	private String ip;

	/**
	 * Date of register 
	 */
	@Column(name="black_list_date")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	

	public Blacklist() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip the ip to set
	 */
	public void setIp(final String ip) {
		this.ip = ip;
	}

	/**
	 * @return the createAt
	 */
	public Date getCreateAt() {
		return createAt;
	}

	/**
	 * @param createAt the createAt to set
	 */
	public void setCreateAt(final Date createAt) {
		this.createAt = createAt;
	}

	
	

}
