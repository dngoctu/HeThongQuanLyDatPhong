package com.dnt.roombooking.address;

import com.dnt.roombooking.exception.AddressNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public List<AddressResponse> findAllAddress() {
        return addressRepository.findAll().stream().map(addressMapper::toAddressResponse).toList();
    }

    public List<AddressResponse> findAllAddressByCity(String city) {
        return addressRepository.findAllByCity(city)
                .stream().map(addressMapper::toAddressResponse).toList();
    }

//    public List<AddressResponse> findAllAddressByCityAndDistrict(String city, String district) {
//        return addressRepository.findAllByCityAndDistrict(city, district)
//                .stream().map(addressMapper::toAddressResponse).toList();
//    }

//    public AddressResponse findAddressById(Integer addressId) {
//        return addressRepository.findById(addressId).map(addressMapper::toAddressResponse)
//                .orElseThrow(() -> new AddressNotFoundException(String.format("Không tìm thấy địa chỉ %s", addressId)));
//    }

    public List<AddressResponse> findAllByCityAndDistrictAndNameContaining(String city, String district, String name) {
        return addressRepository.findAllByCityAndDistrictAndNameContaining(city, district, name)
                .stream().map(addressMapper::toAddressResponse).toList();
    }

    public AddressResponse createAddress(AddressRequest addressRequest) {
        var address = addressRepository.save(addressMapper.toAddress(addressRequest));
        return addressMapper.toAddressResponse(address);
    }

    public AddressResponse updateAddress(AddressRequest addressRequest) {
        var address = addressRepository.findById(addressRequest.id())
                .orElseThrow(() -> new AddressNotFoundException(String.format("Không tìm thấy điểm %s", addressRequest.id())));

        this.mergeAddress(address, addressRequest);
        return addressMapper.toAddressResponse(address);
    }

    private void mergeAddress(Address user, AddressRequest userRequest) {
        if(StringUtils.isNotBlank(userRequest.name()))
            user.setName(userRequest.name());

        if(StringUtils.isNotBlank(userRequest.district()))
            user.setDistrict(userRequest.district());

        if(StringUtils.isNotBlank(userRequest.city()))
            user.setCity(userRequest.city());
    }

    public void deleteAddress(Integer addressId) {
        var address = addressRepository.findById(addressId)
                .orElseThrow(() -> new AddressNotFoundException(String.format("Không tìm thấy địa điểm %s", addressId)));
        addressRepository.delete(address);
    }

}
