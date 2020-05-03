package com.smartosc.training.webservice.service.impl;

import com.smartosc.training.entity.CustomUserDetails;
import com.smartosc.training.model.RoleDTO;
import com.smartosc.training.model.UserDTO;
import com.smartosc.training.webservice.entity.Role;
import com.smartosc.training.webservice.entity.User;
import com.smartosc.training.webservice.mapper.RoleMapper;
import com.smartosc.training.webservice.mapper.UserMapper;
import com.smartosc.training.webservice.service.RoleService;
import com.smartosc.training.webservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public UserDetailsServiceImpl(
            final UserServiceImpl userService,
            final RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        try {
            User result = userService.findByEmail(email);
            UserDTO user = UserMapper.INSTANCE.userToUserDTO(result);
            CustomUserDetails userDetails = null;
            if (user != null) {
                List<Role> results = roleService.findByUsersEmail(email);
                List<GrantedAuthority> grandList = null;
                if(!CollectionUtils.isEmpty(results)) {
                    List<RoleDTO> roles = results.stream()
                            .map(RoleMapper.INSTANCE::roleToRoleDTO)
                            .collect(Collectors.toList());
                    grandList = roles.stream()
                            .map(o -> new SimpleGrantedAuthority(o.getName()))
                            .collect(Collectors.toList());
                }
                user.setRoles(grandList);
                userDetails = new CustomUserDetails(user.getUuid(), email, user.getPassword(), user.getUserName(),
                        user.getFullName(), !user.isBlocked(), user.isEnabled(), user.getRoles());
            }
            return userDetails;
        } catch (Exception e) {
            throw new UsernameNotFoundException("Account with email like \"" + email + "\" not found!");
        }
    }

}
