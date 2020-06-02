package com.smartosc.training.webservice.repository;

import com.smartosc.training.webservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Set<Role> findByUsersEmail(String email);

}
