package com.smartosc.training.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.security.core.GrantedAuthority;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class UserDTO extends RepresentationModel<UserDTO> {

    @NotEmpty
    private String uuid;
    @NotEmpty
    @Size(min = 8, max = 30)
    private String userName;
    @NotEmpty
    private String password;
    private String matchingPassword;
    @NotEmpty
    private String fullName;
    @NotEmpty
    private String email;
    @NotEmpty
    @Size(min = 10, max = 10)
    private String phoneNumber;
    @NotEmpty
    private String address;
    private boolean enabled;
    private boolean blocked;
    private Date createdAt;
    private Date updatedAt;
    private Set<GrantedAuthority> roles;

}
