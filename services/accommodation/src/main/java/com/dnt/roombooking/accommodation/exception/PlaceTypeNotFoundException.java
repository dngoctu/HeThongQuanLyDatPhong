package com.dnt.roombooking.accommodation.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PlaceTypeNotFoundException extends RuntimeException {
    private final String message;
}
