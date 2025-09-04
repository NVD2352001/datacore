package com.trucdulieu.commoncategory.model.converter;

import com.trucdulieu.commoncategory.model.dto.ManufacturingCountryDto;
import com.trucdulieu.commoncategory.model.entity.ManufacturingCountry;

public class ManufacturingCountryConverter {
    public static ManufacturingCountryDto connverDto(ManufacturingCountry manufacturingCountry) {
        ManufacturingCountryDto output = new ManufacturingCountryDto();
        if (manufacturingCountry.getId() != null) output.setId(manufacturingCountry.getId());
        if (manufacturingCountry.getName() != null) output.setName(manufacturingCountry.getName());
        if (manufacturingCountry.getDescription() != null) output.setDescription(manufacturingCountry.getDescription());
        return output;
    }

    public static ManufacturingCountryDto connverDto(ManufacturingCountry manufacturingCountry,ManufacturingCountryDto output) {
        if (manufacturingCountry.getId() != null) output.setId(manufacturingCountry.getId());
        if (manufacturingCountry.getName() != null) output.setName(manufacturingCountry.getName());
        if (manufacturingCountry.getDescription() != null) output.setDescription(manufacturingCountry.getDescription());
        return output;
    }
    public static ManufacturingCountry convertEntity(ManufacturingCountryDto manufacturingCountryDto) {
        ManufacturingCountry output= new ManufacturingCountry();
        if (manufacturingCountryDto.getId() != null) output.setId(manufacturingCountryDto.getId());
        if (manufacturingCountryDto.getName() != null) output.setName(manufacturingCountryDto.getName());
        if (manufacturingCountryDto.getDescription() != null) output.setDescription(manufacturingCountryDto.getDescription());
        return output;
    }
    public static ManufacturingCountry convertEntity(ManufacturingCountryDto manufacturingCountryDto, ManufacturingCountry output) {
        if (manufacturingCountryDto.getId() != null)output.setId(manufacturingCountryDto.getId());
        if (manufacturingCountryDto.getName() != null) output.setName(manufacturingCountryDto.getName());
        if (manufacturingCountryDto.getDescription() != null) output.setDescription(manufacturingCountryDto.getDescription());
        return output;
    }
}
