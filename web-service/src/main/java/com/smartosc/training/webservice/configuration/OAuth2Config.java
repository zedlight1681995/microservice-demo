package com.smartosc.training.webservice.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;

@Configuration
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

    @Value("${config.oauth2.clientId}")
    private String clientId;
    @Value("${config.oauth2.clientSecret}")
    private String clientSecret;
    @Value("${config.oauth2.privateKey}")
    private String privateKey;
    @Value("${config.oauth2.publicKey}")
    private String publicKey;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public OAuth2Config(final PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }



}
