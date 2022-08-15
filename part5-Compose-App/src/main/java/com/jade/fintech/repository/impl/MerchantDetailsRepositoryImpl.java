package com.jade.fintech.repository.impl;

import com.jade.fintech.repository.MerchantDetailsRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Josiah Adetayo
 * @Email: j.adetayo@bcs.org.uk, josiah.adetayo@cwg-plc.com
 * @Date: 8/5/22
 */
@Service
public class MerchantDetailsRepositoryImpl implements MerchantDetailsRepository {

    private final Map<String, String> logoMapping = new HashMap<>();

    public MerchantDetailsRepositoryImpl() {}

    private void setLogoMapping() {
        logoMapping.put("acme", "acme-logo.png");
        logoMapping.put("globex", "globex-logo.png");
        logoMapping.put("morley", "morley-logo.png");
        logoMapping.put("contoso", "contoso-logo.png");
    }

    @Override
    public String getLogo(String name) {
        if(name == null) return "";
        if(logoMapping.isEmpty()) setLogoMapping();
        return logoMapping.get(name.toLowerCase());
    }


}
