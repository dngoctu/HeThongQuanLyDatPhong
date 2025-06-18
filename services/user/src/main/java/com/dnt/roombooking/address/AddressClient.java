package com.dnt.roombooking.address;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "address-service", url = "${application.config.address-url}")
public interface AddressClient {
    @GetMapping("/{address-id}")
    AddressResponse getAddressById(@PathVariable("address-id") Integer id);

    @PostMapping
    AddressResponse createAddress(@RequestBody AddressRequest addressRequest);
}
