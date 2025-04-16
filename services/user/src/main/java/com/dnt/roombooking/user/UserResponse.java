package com.dnt.roombooking.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UserResponse (
        Integer id,
        String firstName,
        String lastName,
        String email,
        String description,
        User.Role role
){
}
