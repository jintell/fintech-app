package com.jade.fintech.repository.impl;

import com.jade.fintech.repository.MerchantDetailsRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Josiah Adetayo
 * @Email: j.adetayo@bcs.org.uk, josiah.adetayo@cwg-plc.com
 * @Date: 8/5/22
 */
@Component
public class MerchantDetailsRepositoryImpl implements MerchantDetailsRepository {

    private final Map<String, String> logoMapping;

    public MerchantDetailsRepositoryImpl() {
        logoMapping = new HashMap<>();
        logoMapping.put("acme", "acme-logo.png");
        logoMapping.put("globex", "globex-logo.png");
        logoMapping.put("morley", "morley-logo.png");
        logoMapping.put("contoso", "contoso-logo.png");
    }

    @Override
    public String getLogo(String name) {
        return logoMapping.get(name.toLowerCase());
    }


}
