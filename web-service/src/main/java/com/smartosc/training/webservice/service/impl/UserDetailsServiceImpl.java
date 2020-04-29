package com.smartosc.training.webservice.service.impl;

import com.smartosc.training.dto.RoleDTO;
import com.smartosc.training.dto.UserDTO;
import com.smartosc.training.entity.CustomUserDetails;
import com.smartosc.training.webservice.facade.UserFacade;
import com.smartosc.training.webservice.facade.RoleFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserFacade userFacade;
    private final RoleFacade roleFacade;

    @Autowired
    public UserDetailsServiceImpl(final UserFacade userFacade, final RoleFacade roleFacade) {
        this.userFacade = userFacade;
        this.roleFacade = roleFacade;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            UserDTO user = userFacade.findByEmail(email);
            CustomUserDetails userDetails = null;
            if(user != null) {
                List<RoleDTO> roles = roleFacade.findByUsers_Email(email);
                List<GrantedAuthority> grandList = null;
                if (roles != null) {
                    grandList = roles.stream()
                            .map(o -> new SimpleGrantedAuthority(o.getName()))
                            .collect(Collectors.toList());
                }
                user.setRoles(grandList);
                userDetails = new CustomUserDetails(user.getUuid(), email, user.getPassword(), user.getUserName(),
                        user.getFullName(), user.isBlocked(), user.isEnabled(),  user.getRoles());
            }
            return userDetails;
        } catch (Exception e) {
            throw new UsernameNotFoundException("Account with email like \"" + email + "\" not found!");
        }
    }

}
