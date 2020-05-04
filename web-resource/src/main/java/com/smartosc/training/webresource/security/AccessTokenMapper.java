package com.smartosc.training.webresource.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccessTokenMapper {

    private String uuid;
    private String email;
    private String username;
    private String fullName;

}
