package com.dnt.roombooking.user;

import com.dnt.roombooking.address.AddressResponse;

public record UserResponse (
        Integer id,
        String firstName,
        String lastName,
        String email,
        String description,
        User.Role role,
        AddressResponse address
){
}
