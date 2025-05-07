package com.dnt.roombooking.handler;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {

}
