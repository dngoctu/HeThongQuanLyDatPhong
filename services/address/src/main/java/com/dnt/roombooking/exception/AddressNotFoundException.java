package com.dnt.roombooking.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AddressNotFoundException extends RuntimeException {
    private final String message;
}
