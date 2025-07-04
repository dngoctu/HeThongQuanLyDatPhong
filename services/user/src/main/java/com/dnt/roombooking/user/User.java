package com.dnt.roombooking.user;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String description;
    private Integer addressId;

    // Enum cho Role
    public enum Role {
        partner,  // Đối tác
        admin, // Quản trị viên
        customer // Khách hàng
    }

    // Constructors
//    public User() {
//    }
//
//    public User(String firstName, String lastName, String email, String password, Role role, String description) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.password = password;
//        this.role = role;
//        this.description = description;
//    }
}
