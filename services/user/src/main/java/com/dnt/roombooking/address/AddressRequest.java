package com.dnt.roombooking.address;

public record AddressRequest(
        Integer id,
        String name,
        String district,
        String city
) {}
