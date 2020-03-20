package com.smartosc.training.entity;

import com.smartosc.training.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.User;

@Getter
@Setter
public class CustomUserDetails extends User {

    private String uuid;
    private String username;
    private String fullName;
    private boolean blocked;
    private boolean enabled;

    public CustomUserDetails(UserDTO user) {
        super(user.getEmail(), user.getPassword(), user.getRoles());
        this.uuid = user.getUuid();
        this.username = user.getUserName();
        this.fullName = user.getFullName();
        this.blocked = user.isBlocked();
        this.enabled = user.isEnabled();
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
