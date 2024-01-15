package com.nolefrom.springboot.app.item;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean("clienteRest")
    @LoadBalanced //Usará Ribbon para balanceo de carga en "RestTempleate"
    public RestTemplate registrarRestTemplate(){
        return new RestTemplate();
    }
}
