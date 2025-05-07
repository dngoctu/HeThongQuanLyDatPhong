package com.dnt.roombooking.user;

public record UserResponse (
        Integer id,
        String firstName,
        String lastName,
        String email,
        String description,
        User.Role role,
        Integer addressId
){
}
