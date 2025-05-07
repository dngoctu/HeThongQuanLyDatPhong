package com.dnt.roombooking.address;

import org.springframework.stereotype.Service;

@Service
public class AddressMapper {

    public Address toAddress(AddressRequest addressRequest) {
        return Address.builder()
                .name(addressRequest.name())
                .district(addressRequest.district())
                .city(addressRequest.city())
                .build();
    }

    public AddressResponse toAddressResponse(Address address) {
        return new AddressResponse(
                address.getId(),
                address.getName(),
                address.getDistrict(),
                address.getCity()
        );
    }
}
