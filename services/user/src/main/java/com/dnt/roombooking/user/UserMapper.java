package com.dnt.roombooking.user;

import com.dnt.roombooking.address.AddressClient;
import com.dnt.roombooking.address.AddressRequest;
import com.dnt.roombooking.address.AddressResponse;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    private final AddressClient addressClient;

    public UserMapper(AddressClient addressClient) {
        this.addressClient = addressClient;
    }

    public User toUser(UserRequest userRequest) {
        if(userRequest == null) return null;
        AddressRequest addressRequest = userRequest.address();
        AddressResponse addressResponse = addressClient.createAddress(addressRequest);
        return User.builder()
                .firstName(userRequest.firstName())
                .lastName(userRequest.lastName())
                .email(userRequest.email())
                .role(userRequest.role())
                .description(userRequest.description())
                .addressId(addressResponse.id())
                .build();
    }

    public UserResponse toUserResponse(User user) {
        AddressResponse address = addressClient.getAddressById(user.getAddressId());
        return new UserResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getDescription(),
                user.getRole(),
                address
        );
    }
}
