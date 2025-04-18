package com.dnt.roombooking.address;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Address {

    @Id
    private Integer id;
    private String name;
    private String district;
    private String city;

}
