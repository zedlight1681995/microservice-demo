package com.smartosc.training.webresource.security;

import org.springframework.boot.autoconfigure.security.oauth2.resource.JwtAccessTokenConverterConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class JwConverter extends DefaultAccessTokenConverter implements JwtAccessTokenConverterConfigurer {

    @Override
    public void configure(JwtAccessTokenConverter converter) {
        converter.setAccessTokenConverter(this);
    }

    @Override
    public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
        OAuth2Authentication auth = super.extractAuthentication(map);
        AccessTokenMapper details = new AccessTokenMapper();

        if(map.get("uuid") != null)
            details.setUuid(map.get("uuid").toString());
        if(map.get("email") != null)
            details.setEmail(map.get("email").toString());
        if(map.get("username") != null)
            details.setUsername(map.get("username").toString());
        if(map.get("fullName") != null)
            details.setFullName(map.get("fullName").toString());
        auth.setDetails(details);
        return auth;
    }
}
