package org.joann.springsecurityapi2.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    @NotNull
    @Size(min = 3, max = 50)
    private String username;

    @NotNull
    @Size(min = 8)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();

    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public @NotNull @Size(min = 3, max = 50) String getUsername() {
        return username;
    }

    public void setUsername(@NotNull @Size(min = 3, max = 50) String username) {
        this.username = username;
    }

    public @NotNull @Size(min = 8) String getPassword() {
        return password;
    }

    public void setPassword(@NotNull @Size(min = 8) String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}

