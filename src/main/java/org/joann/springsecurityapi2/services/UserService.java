package org.joann.springsecurityapi2.services;

import org.joann.springsecurityapi2.dto.UserDto;
import org.joann.springsecurityapi2.entities.Role;
import org.joann.springsecurityapi2.entities.User;
import org.joann.springsecurityapi2.repositories.RoleRepository;
import org.joann.springsecurityapi2.repositories.UserRepository;
import org.owasp.encoder.Encode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Inject RoleRepository to handle role-related operations
    @Autowired
    private RoleRepository roleRepository;

    // Inject UserRepository to handle user-related operations
    @Autowired
    private UserRepository userRepository;

    // Other methods, including registering the user
    public User registerUser(UserDto userDto) {
        // Sanitize input and encode password
        String sanitizedUsername = Encode.forHtml(userDto.getUsername());
        String encodedPassword = passwordEncoder.encode(Encode.forHtml(userDto.getPassword()));

        // Create and save the new user
        User user = new User();
        user.setUsername(sanitizedUsername);
        user.setPassword(encodedPassword);

        // Retrieve the role by name from the repository
        Optional<Role> userRole = roleRepository.findByName("ROLE_USER");

        if (userRole.isPresent()) {
            user.setRoles(Set.of(userRole.get()));  // Set the role if found
        } else {
            throw new RuntimeException("Role not found!");  // Handle case where role isn't found
        }

        return userRepository.save(user);  // Save the user
    }
}
