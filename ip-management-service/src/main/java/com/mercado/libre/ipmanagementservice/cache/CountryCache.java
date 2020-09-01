package com.mercado.libre.ipmanagementservice.cache;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * Componente que genera un mapa de cache, para almacenar los paises.
 * @author Julian
 *
 */
@Component
public class CountryCache {
	
	
	/**
	 * Cache de paises
	 */
		private  Map<String, Object> country = new HashMap<>();
	  
		@Cacheable("map")
	    public Map<String, Object> getMap() {
			if(country ==null)
				country=new HashMap<>();
	        return this.country;
	    }

		/**
		 * 
		 * @return
		 */
		public Map<String, Object> getCountry() {
			return country;
		}

		/**
		 * 
		 * @param country
		 */
		public void setCountry(Map<String, Object> country) {
			this.country = country;
		}

}
