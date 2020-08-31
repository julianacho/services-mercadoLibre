package com.mercado.libre.ipmanagementservice.cache;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class CountryCache {
	
		private  Map<String, Object> country = new HashMap<>();
	  
		@Cacheable("map")
	    public Map<String, Object> getMap() {
			if(country ==null)
				country=new HashMap<>();
	        return this.country;
	    }

		public Map<String, Object> getCountry() {
			return country;
		}

		public void setCountry(Map<String, Object> country) {
			this.country = country;
		}

}
