package com.trucdulieu.commoncategory.model.converter;

import com.trucdulieu.commoncategory.model.entity.City;
import com.trucdulieu.commoncategory.model.dto.CityCreationDto;
import com.trucdulieu.commoncategory.model.dto.CityDto;

public class CityMapper {

    public static City toEntity(CityCreationDto req) {
        City city = new City();
        if(req.getName() != null)
            city.setName(req.getName());
        if(req.getDescription() != null)
            city.setDescription(req.getDescription());
        if(req.getRegions() != null)
            city.setRegions(req.getRegions());
        if(req.getZipCode() != null)
            city.setZipCode(req.getZipCode());
        return city;
    }

    public static CityDto toDTO(City city) {
        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .description(city.getDescription())
                .regions(city.getRegions())
                .zipCode(city.getZipCode())
                .createdAt(city.getCreatedAt())
                .updatedAt(city.getUpdatedAt())
                .createdBy(city.getCreatedBy())
                .updatedBy(city.getUpdatedBy())
                .build();
    }

    public static City forUpdate(City city, CityDto req) {
//        if(req.getId() != null)
//            city.setId(req.getId());
        if(req.getName() != null)
            city.setName(req.getName());
        if(req.getDescription() != null)
            city.setDescription(req.getDescription());
        if(req.getRegions() != null)
            city.setRegions(req.getRegions());
        if(req.getZipCode() != null)
            city.setZipCode(req.getZipCode());
        if(req.getCreatedAt() != null)
            city.setCreatedAt(req.getCreatedAt());
        if(req.getUpdatedAt() != null)
            city.setUpdatedAt(req.getUpdatedAt());
        if(req.getCreatedBy() != null)
            city.setCreatedBy(req.getCreatedBy());
        if(req.getUpdatedBy() != null)
            city.setUpdatedBy(req.getUpdatedBy());
        return city;
    }
}
