package com.smartosc.training.entity;

import com.smartosc.training.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@Getter
@Setter
public class CustomUserDetails extends User {

    private String uuid;
    private String username;
    private String fullName;
    private boolean blocked;
    private boolean enabled;

    public CustomUserDetails(
            String uuid, String email, String password, String username,
            String fullName, boolean blocked, boolean enabled, List<GrantedAuthority> roles) {
        super(email, password, roles);
        this.uuid = uuid;
        this.username = username;
        this.fullName = fullName;
        this.blocked = blocked;
        this.enabled = enabled;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.blocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
