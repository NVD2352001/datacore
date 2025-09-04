package com.trucdulieu.commoncategory.model.converter;


import com.trucdulieu.commoncategory.model.dto.SickBedDto;
import com.trucdulieu.commoncategory.model.entity.SickBed;

public class SickBedConverter {
    public static SickBedDto convertDto(SickBed sickBed){
        SickBedDto sickBedDto = new SickBedDto();
        if (sickBed.getId() != null) sickBedDto.setId(sickBed.getId());
        if (sickBed.getName() != null) sickBedDto.setName(sickBed.getName());
        return sickBedDto;
    }
    public static SickBedDto convertDto(SickBed sickBed, SickBedDto sickBedDto){
        if (sickBed.getId() != null) sickBedDto.setId(sickBed.getId());
        if (sickBed.getName() != null) sickBedDto.setName(sickBed.getName());
        return sickBedDto;
    }
    public static  SickBed convertEntity(SickBedDto sickBedDto){
        SickBed sickBed = new SickBed();
        if (sickBedDto.getId() != null) sickBed.setId(sickBedDto.getId());
        if (sickBedDto.getName() != null ) sickBed.setName(sickBedDto.getName());
        return sickBed;
    }
    public static SickBed convertEntity(SickBedDto sickBedDto, SickBed sickBed){
        if (sickBedDto.getId() != null) sickBed.setId(sickBedDto.getId());
        if (sickBedDto.getName() != null) sickBed.setName(sickBedDto.getName());
        return sickBed;
    }
}
