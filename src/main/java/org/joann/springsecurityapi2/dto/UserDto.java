package org.joann.springsecurityapi2.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDto {

    @NotNull
    @Size(min = 3, max = 50)
    private String username;

    @NotNull
    @Size(min = 8, max = 100)
    private String password;

    public @NotNull @Size(min = 3, max = 50) String getUsername() {
        return username;
    }

    public void setUsername(@NotNull @Size(min = 3, max = 50) String username) {
        this.username = username;
    }

    public @NotNull @Size(min = 8, max = 100) String getPassword() {
        return password;
    }

    public void setPassword(@NotNull @Size(min = 8, max = 100) String password) {
        this.password = password;
    }
}

