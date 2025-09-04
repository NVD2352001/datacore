package com.trucdulieu.commoncategory.model.converter;

import com.trucdulieu.commoncategory.model.dto.WardDto;
import com.trucdulieu.commoncategory.model.entity.Ward;

public class WardConverter {
    public static WardDto convertToDto(Ward ward){
        WardDto wardDto = new WardDto();
        if (ward.getId() != null) wardDto.setId(ward.getId());
        if (ward.getName() != null) wardDto.setName(ward.getName());
        if (ward.getDescription() != null) wardDto.setDescription(ward.getDescription());
        return wardDto;
    }
    public static Ward convertToEntity(WardDto wardDto){
        Ward ward = new Ward();
        if (wardDto.getId() != null) ward.setId(wardDto.getId());
        if (wardDto.getName() != null) ward.setName(wardDto.getName());
        if (wardDto.getDescription() != null) ward.setDescription(wardDto.getDescription());
        return ward;
    }
    public static Ward convertToEntity(WardDto wardDto, Ward ward){
        if (wardDto.getId() != null) ward.setId(wardDto.getId());
        if (wardDto.getDescription() != null) ward.setDescription(wardDto.getDescription());
        if (wardDto.getName() != null) ward.setName(wardDto.getName());
        return ward;
    }
}
