package com.jade.fintech.service;

import com.jade.fintech.domain.AccessTokenDto;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @Author: Josiah Adetayo
 * @Email: j.adetayo@bcs.org.uk, josiah.adetayo@cwg-plc.com
 * @Date: 8/12/22
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AccessTokenService {

    private final WebClient webClient;

    @Value("${open.banking.token.url}")
    private String tokenEndpoint;

    @Value("${open.banking.client_id}")
    private String clientId;
    @Value("${open.banking.client_secret}")
    private String clientSecret;

    public AccessTokenDto getToken() {
        return webClient.post()
                .uri(tokenEndpoint)
                .header("Authorization", httpBasic(clientId, clientSecret))
                .body(BodyInserters.fromFormData(getFormParams()))
                .retrieve()
                .bodyToMono(AccessTokenDto.class)
                .block();

    }

    private String httpBasic(String username, String password) {
        if(username == null || password == null) return "";

        return "Basic " + Base64.encodeBase64String((username+":"+password).getBytes());
    }

    private MultiValueMap getFormParams() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "client_credentials");

        return params;
    }
}
