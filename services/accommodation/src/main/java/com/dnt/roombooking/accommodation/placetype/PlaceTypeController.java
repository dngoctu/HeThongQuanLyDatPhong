package com.dnt.roombooking.accommodation.placetype;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/placetype")
@RequiredArgsConstructor
public class PlaceTypeController {
    private final PlaceTypeService placeTypeService;

    @GetMapping
    public ResponseEntity<?> getPlaceTypes(@RequestParam(required = false) String name) {
        if (name != null && !name.isEmpty()) {
            return ResponseEntity.ok(placeTypeService.findPlaceTypeByName(name));
        } else {
            return ResponseEntity.ok(placeTypeService.findAllPlaceType());
        }
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
