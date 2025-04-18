package com.dnt.roombooking.address;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping
    public ResponseEntity<List<AddressResponse>> findAllAddress() {
        return ResponseEntity.ok(addressService.findAllAddress());
    }

    // Người dùng sẽ tìm kiếm theo tham số
    @GetMapping("/search")
    public ResponseEntity<List<AddressResponse>> getByCityAndDistrictAndContainName(
            @RequestParam String city,
            @RequestParam String district,
            @RequestParam String name
    ) {
        return ResponseEntity.ok(addressService.findAddressByCityAndDistrictAndContainName(city, district, name));
    }

    // Để người dùng chọn 1 thành phố và hiển thị toàn bộ danh sách
    @GetMapping("/city/{city}")
    public ResponseEntity<List<AddressResponse>> getByCity(@PathVariable String city) {
        return ResponseEntity.ok(addressService.findAllAddressByCity(city));
    }

    @PostMapping
    public ResponseEntity<AddressResponse> createAddress(
            @RequestBody AddressRequest addressRequest
    ) {
        return ResponseEntity.ok(addressService.createAddress(addressRequest));
    }

    @PutMapping
    public ResponseEntity<AddressResponse> updateAddress(
            @RequestBody AddressRequest addressRequest
    ) {
        return ResponseEntity.ok(addressService.updateAddress(addressRequest));
    }

    @DeleteMapping("/{address-id}")
    public ResponseEntity<String> deleteAddress(
            @PathVariable("address-id") Integer addressId
    ) {
        addressService.deleteAddress(addressId);
        return ResponseEntity.ok("Xóa địa điểm thành công");
    }
}
