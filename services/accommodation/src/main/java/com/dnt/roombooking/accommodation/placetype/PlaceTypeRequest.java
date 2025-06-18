package com.dnt.roombooking.accommodation.placetype;

import jakarta.validation.constraints.NotNull;

public record PlaceTypeRequest(
    Integer id,
    @NotNull(message = "Vui lòng nhập loại địa điểm")
    String name,
    String description
) {
}
