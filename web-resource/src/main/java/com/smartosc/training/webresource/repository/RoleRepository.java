package com.smartosc.training.webresource.repository;

import com.smartosc.training.webresource.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    List<Role> findByUsers_Email(String email);

}
