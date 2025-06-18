package com.dnt.roombooking.accommodation.placetype;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceTypeRepository extends JpaRepository<PlaceType, Integer> {
    public PlaceType findPlaceTypeByName(String name);
}
