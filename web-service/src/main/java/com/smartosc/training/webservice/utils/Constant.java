package com.smartosc.training.webservice.utils;

public class Constant {

    private Constant() {
        throw new IllegalStateException("Utility class");
    }

    //Oauth2 Scope
    public static final String SCOPE_READ = "read";
    public static final String SCOPE_WRITE = "write";

    //Oauth2 Grant Type
    public static final String GRANT_TYPE_PASSWORD = "password";
    public static final String GRANT_TYPE_REFRESH_TOKEN = "refresh_token";
    public static final String GRANT_TYPE_CLIENT_CREDENTIALS = "client_credentials";
    public static final String GRANT_TYPE_AUTHORIZATION_CODE = "authorization_code";

    public static final String ENTITY_NOTFOUND_ERROR = "entity.notfound.error";

}
