package com.smartosc.training.webservice.security;

import com.smartosc.training.dto.RoleDTO;
import com.smartosc.training.dto.UserDTO;
import com.smartosc.training.webservice.facade.UserFacade;
import com.smartosc.training.webservice.facade.mapper.RoleFacade;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
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

    public UserDetailsServiceImpl(final UserFacade userFacade, final RoleFacade roleFacade) {
        this.userFacade = userFacade;
        this.roleFacade = roleFacade;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            UserDTO user = userFacade.findByUsername(username);
            List<RoleDTO> roles = roleFacade.findByUsername(username);
            List<GrantedAuthority> grandList = roles.stream()
                                .map(o -> new SimpleGrantedAuthority(o.getName()))
                                .collect(Collectors.toList());
            return new User(user.getUserName(), user.getPassword(), user.isEnabled(),
                    true, true, user.isBlocked(),
                    grandList);
        } catch (Exception e) {
            throw new UsernameNotFoundException(username + " not found!");
        }
    }

}
