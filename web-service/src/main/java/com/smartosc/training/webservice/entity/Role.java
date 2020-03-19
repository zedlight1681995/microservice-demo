package com.smartosc.training.webservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
                joinColumns = { @JoinColumn(name = "role_id") },
                inverseJoinColumns = { @JoinColumn(name = "user_id") })
    private List<User> users;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "role_permission",
                joinColumns = { @JoinColumn(name = "role_id") },
                inverseJoinColumns = { @JoinColumn(name = "permission_id") })
    private List<Permission> permissions;

}
