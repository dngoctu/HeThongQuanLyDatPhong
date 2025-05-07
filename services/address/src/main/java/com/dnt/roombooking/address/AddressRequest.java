package com.dnt.roombooking.address;

import jakarta.validation.constraints.NotNull;

public record AddressRequest(

        Integer id,
        @NotNull(message = "Vui lòng nhập số nhà, đường")
        String name,
        @NotNull(message = "Vui lòng chọn quận/huyện")
        String district,
        @NotNull(message = "Vui lòng chọn tỉnh/thành phố")
        String city
) {
}
