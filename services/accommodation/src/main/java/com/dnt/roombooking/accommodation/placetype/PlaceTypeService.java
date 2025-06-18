package com.dnt.roombooking.accommodation.placetype;

import com.dnt.roombooking.accommodation.exception.PlaceTypeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceTypeService {

    private final PlaceTypeRepository placeTypeRepository;
    private final PlaceTypeMapper placeTypeMapper;

    public PlaceTypeResponse findPlaceTypeByName(String name) {
        PlaceType placeType = placeTypeRepository.findPlaceTypeByName(name);
        return placeTypeMapper.toPlaceTypeResponse(placeType);
    }

    public List<PlaceTypeResponse> findAllPlaceType() {
        return placeTypeRepository.findAll().stream().map(placeTypeMapper::toPlaceTypeResponse).toList();
    }

    public PlaceTypeResponse createPlaceType(PlaceTypeRequest placeTypeRequest) {
        PlaceType placeType = placeTypeRepository.save(placeTypeMapper.toPlaceType(placeTypeRequest));
        return placeTypeMapper.toPlaceTypeResponse(placeType);
    }

    private void mergePlaceType(PlaceType placeType, PlaceTypeRequest placeTypeRequest) {
        if (StringUtils.isNotBlank(placeTypeRequest.name())){
            placeType.setName(placeTypeRequest.name());
        }
        if (StringUtils.isNotBlank(placeTypeRequest.description())){
            placeType.setDescription(placeTypeRequest.description());
        }
    }

    public PlaceTypeResponse updatePlaceType(PlaceTypeRequest placeTypeRequest) {
        PlaceType placeType = placeTypeRepository.findById(placeTypeRequest.id())
                .orElseThrow(() -> new PlaceTypeNotFoundException(
                        String.format("Không tìm thấy loại phòng %s", placeTypeRequest.name())));
        mergePlaceType(placeType, placeTypeRequest);
        return placeTypeMapper.toPlaceTypeResponse(placeType);
    }

    public void deletePlaceType(Integer placeTypeId) {
        PlaceType placeType = placeTypeRepository.findById(placeTypeId)
                .orElseThrow(() -> new PlaceTypeNotFoundException(
                        String.format("Không tìm thấy loại phòng %s", placeTypeId)));
        placeTypeRepository.delete(placeType);
    }
}
