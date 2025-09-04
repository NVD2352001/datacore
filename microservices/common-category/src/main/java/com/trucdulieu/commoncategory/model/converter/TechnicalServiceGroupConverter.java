package com.trucdulieu.commoncategory.model.converter;

import com.trucdulieu.commoncategory.model.dto.TechnicalServiceGroupDto;
import com.trucdulieu.commoncategory.model.entity.TechnicalServiceGroup;

public class TechnicalServiceGroupConverter {
    public static TechnicalServiceGroupDto connverDto(TechnicalServiceGroup technicalServiceGroup) {
        TechnicalServiceGroupDto output = new TechnicalServiceGroupDto();
        if (technicalServiceGroup.getId() != null) output.setId(technicalServiceGroup.getId());
        if (technicalServiceGroup.getName() != null) output.setName(technicalServiceGroup.getName());
        if (technicalServiceGroup.getDescription() != null) output.setDescription(technicalServiceGroup.getDescription());
        return output;
    }

    public static TechnicalServiceGroupDto connverDto(TechnicalServiceGroup technicalServiceGroup,TechnicalServiceGroupDto output) {
        if (technicalServiceGroup.getId() != null) output.setId(technicalServiceGroup.getId());
        if (technicalServiceGroup.getName() != null) output.setName(technicalServiceGroup.getName());
        if (technicalServiceGroup.getDescription() != null) output.setDescription(technicalServiceGroup.getDescription());
        return output;
    }
    public static TechnicalServiceGroup convertEntity(TechnicalServiceGroupDto technicalServiceGroupDto) {
        TechnicalServiceGroup output= new TechnicalServiceGroup();
        if (technicalServiceGroupDto.getId() != null) output.setId(technicalServiceGroupDto.getId());
        if (technicalServiceGroupDto.getName() != null) output.setName(technicalServiceGroupDto.getName());
        if (technicalServiceGroupDto.getDescription() != null) output.setDescription(technicalServiceGroupDto.getDescription());
        return output;
    }
    public static TechnicalServiceGroup convertEntity(TechnicalServiceGroupDto technicalServiceGroupDto, TechnicalServiceGroup output) {
        if (technicalServiceGroupDto.getId() != null)output.setId(technicalServiceGroupDto.getId());
        if (technicalServiceGroupDto.getName() != null) output.setName(technicalServiceGroupDto.getName());
        if (technicalServiceGroupDto.getDescription() != null) output.setDescription(technicalServiceGroupDto.getDescription());
        return output;
    }
}
