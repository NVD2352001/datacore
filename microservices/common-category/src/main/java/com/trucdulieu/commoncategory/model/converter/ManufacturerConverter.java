package com.trucdulieu.commoncategory.model.converter;

import com.trucdulieu.commoncategory.model.dto.ManufacturerDto;
import com.trucdulieu.commoncategory.model.entity.Manufacturer;

public class ManufacturerConverter {
    public static ManufacturerDto convertDto(Manufacturer manufacturer){
        ManufacturerDto manufacturerDto = new ManufacturerDto();
        if (manufacturer.getId() != null) manufacturerDto.setId(manufacturer.getId());
        if (manufacturer.getName() != null) manufacturerDto.setName(manufacturer.getName());
        if (manufacturer.getCompanyName() != null) manufacturerDto.setCompanyName(manufacturer.getCompanyName());
        if (manufacturer.getDescription() != null) manufacturerDto.setDescription(manufacturer.getDescription());
        return manufacturerDto;
    }
    public static ManufacturerDto convertDto(Manufacturer manufacturer, ManufacturerDto manufacturerDto){
        if (manufacturer.getId() != null) manufacturerDto.setId(manufacturer.getId());
        if (manufacturer.getName() != null) manufacturerDto.setName(manufacturer.getName());
        if (manufacturer.getCompanyName() != null) manufacturerDto.setCompanyName(manufacturer.getCompanyName());
        if (manufacturer.getDescription() != null) manufacturerDto.setDescription(manufacturer.getDescription());
        return manufacturerDto;
    }
    public static Manufacturer convertEntity(ManufacturerDto manufacturerDto) {
        Manufacturer manufacturer = new Manufacturer();
        if (manufacturerDto.getId() != null) manufacturer.setId(manufacturerDto.getId());
        if (manufacturerDto.getName() != null) manufacturer.setName(manufacturerDto.getName());
        if (manufacturerDto.getCompanyName() != null) manufacturer.setCompanyName(manufacturerDto.getCompanyName());
        if (manufacturerDto.getDescription() != null) manufacturer.setDescription(manufacturerDto.getDescription());
        return manufacturer;
    }
    public static Manufacturer convertEntity(ManufacturerDto manufacturerDto, Manufacturer manufacturer){
        if (manufacturerDto.getId() != null) manufacturer.setId(manufacturerDto.getId());
        if (manufacturerDto.getName() != null) manufacturer.setName(manufacturerDto.getName());
        if (manufacturerDto.getCompanyName() != null) manufacturer.setCompanyName(manufacturerDto.getCompanyName());
        if (manufacturerDto.getDescription() != null) manufacturer.setDescription(manufacturerDto.getDescription());
        return manufacturer;
    }


}
