package com.jade.fintech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @Author: Josiah Adetayo
 * @Email: j.adetayo@bcs.org.uk, josiah.adetayo@cwg-plc.com
 * @Date: 7/21/22
 */
@Configuration
public class ProjectConfig {

    @Bean
    public WebClient webClient() {
        return WebClient.create();
    }
}
