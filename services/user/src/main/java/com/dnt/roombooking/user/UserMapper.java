package com.dnt.roombooking.user;

import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public User toUser(UserRequest userRequest) {
        if(userRequest == null) return null;

        return User.builder()
                .firstName(userRequest.firstName())
                .lastName(userRequest.lastName())
                .email(userRequest.email())
                .role(userRequest.role())
                .description(userRequest.description())
                .addressId(userRequest.addressId())
                .build();
    }

    public UserResponse toUserResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getDescription(),
                user.getRole(),
                user.getAddressId());
    }
}
