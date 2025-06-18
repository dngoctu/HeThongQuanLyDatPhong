package com.dnt.roombooking.address;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    public List <Address> findAllByCity(String city);
//    public List <Address> findAllByCityAndDistrict(String city, String district);
    public List <Address> findAllByCityAndDistrictAndNameContaining(String city, String district, String name);
}
