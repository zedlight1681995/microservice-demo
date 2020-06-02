package com.smartosc.training.entity;

import com.smartosc.training.model.RoleDTO;
import com.smartosc.training.model.UserDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class CustomUserDetails extends User {

    private String uuid;
    private String email;
    private String username;
    private String fullName;

    public CustomUserDetails(
            String uuid, String email, String password, String username,
            String fullName, boolean blocked, boolean enabled, Set<GrantedAuthority> roles) {
        super(email, password, enabled, true, true, blocked, roles);
        this.uuid = uuid;
        this.email = email;
        this.username = username;
        this.fullName = fullName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return super.isEnabled();
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return super.getAuthorities();
    }
}
