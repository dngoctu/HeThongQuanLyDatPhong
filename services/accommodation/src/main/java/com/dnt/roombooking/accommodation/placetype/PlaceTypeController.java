package com.dnt.roombooking.accommodation.placetype;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/accommodation/placetype")
@RequiredArgsConstructor
public class PlaceTypeController {
    private final PlaceTypeService placeTypeService;

    @GetMapping
    public ResponseEntity<List<PlaceTypeResponse>> getPlaceTypes() {
        return ResponseEntity.ok(placeTypeService.findAllPlaceType());
    }

    @GetMapping("{placetype-name}")
    public ResponseEntity<PlaceTypeResponse> getPlaceTypeByName(@PathVariable String placetypeName) {
        return ResponseEntity.ok(placeTypeService.findPlaceTypeByName(placetypeName));
    }

    @GetMapping("{id}")
    public ResponseEntity<PlaceTypeResponse> getPlaceTypeById(@PathVariable Integer id) {
        return ResponseEntity.ok(placeTypeService.findPlaceTypeById(id));
    }

    @PostMapping
    public ResponseEntity<PlaceTypeResponse> createPlaceType(
            @RequestBody @Valid PlaceTypeRequest placeTypeRequest) {
        return ResponseEntity.ok(placeTypeService.createPlaceType(placeTypeRequest));
    }

    @PutMapping
    public ResponseEntity<PlaceTypeResponse> updatePlaceType(
            @RequestBody @Valid PlaceTypeRequest placeTypeRequest) {
        return ResponseEntity.ok(placeTypeService.updatePlaceType(placeTypeRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlaceType(@PathVariable Integer id) {
        placeTypeService.deletePlaceType(id);
        return ResponseEntity.ok("Xóa PlaceType thành công");
    }





}
