package com.dnt.roombooking.address;

import jakarta.validation.constraints.NotNull;

public record AddressResponse(
        Integer id,
        String name,
        String district,
        String city
) {
}
