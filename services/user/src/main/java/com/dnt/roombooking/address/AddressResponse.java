package com.dnt.roombooking.address;

public record AddressResponse(
        Integer id,
        String name,
        String district,
        String city
) {}
