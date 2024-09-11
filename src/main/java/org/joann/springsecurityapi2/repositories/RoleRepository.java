package org.joann.springsecurityapi2.repositories;

import org.joann.springsecurityapi2.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    // Method to find a role by its name (matches the field 'name' in the Role entity)
    Optional<Role> findByName(String name);
}
