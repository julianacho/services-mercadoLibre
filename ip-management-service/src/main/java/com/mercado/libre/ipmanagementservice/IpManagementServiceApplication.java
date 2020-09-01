package com.mercado.libre.ipmanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//Permite habilitar el Cliente Feing
@EnableFeignClients
public class IpManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IpManagementServiceApplication.class, args);
	}

}
