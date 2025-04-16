package com.dnt.roombooking.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UserRequest(
        Integer id,

        @NotNull(message = "Cần nhập tên")
        String firstName,

        @NotNull(message = "Cần nhập họ")
        String lastName,

        @NotNull(message = "Cần nhập email")
        @Email(message = "Email không hợp lệ")
        String email,

        String description,
        @NotNull(message = "Vui lòng chọn vai trò")
        User.Role role
){

}
