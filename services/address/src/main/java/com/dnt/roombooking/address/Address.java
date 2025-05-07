package com.dnt.roombooking.address;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String district;
    private String city;

}
