package com.dnt.roombooking.accommodation.placetype;

import org.springframework.stereotype.Service;

@Service
public class PlaceTypeMapper {
    public PlaceType toPlaceType(PlaceTypeRequest placeTypeRequest) {
        return PlaceType.builder()
                .name(placeTypeRequest.name())
                .description(placeTypeRequest.description())
                .build();
    }

    public PlaceTypeResponse toPlaceTypeResponse(PlaceType placeType) {
        return new PlaceTypeResponse(
                placeType.getId(),
                placeType.getName(),
                placeType.getDescription()
                );
    }
}
