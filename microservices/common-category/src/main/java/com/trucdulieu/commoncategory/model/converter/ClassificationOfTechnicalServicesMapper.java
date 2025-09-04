package com.trucdulieu.commoncategory.model.converter;

import com.trucdulieu.commoncategory.model.dto.ClassificationOfTechnicalServicesDto;
import com.trucdulieu.commoncategory.model.entity.ClassificationOfTechnicalServices;

public class ClassificationOfTechnicalServicesMapper {
    public static ClassificationOfTechnicalServicesDto toDTO(ClassificationOfTechnicalServices param) {
        return ClassificationOfTechnicalServicesDto.builder()
                .id(param.getId())
                .name(param.getName())
                .description(param.getDescription())
                .code(param.getCode())
                .createdAt(param.getCreatedAt())
                .updatedAt(param.getUpdatedAt())
                .createdBy(param.getCreatedBy())
                .updatedBy(param.getUpdatedBy())
                .build();
    }

    public static ClassificationOfTechnicalServices forUpdate(ClassificationOfTechnicalServices value, ClassificationOfTechnicalServicesDto req) {
        if (req.getName() != null)
            value.setName(req.getName());
        if (req.getDescription() != null)
            value.setDescription(req.getDescription());
        if (req.getCode() != null)
            value.setCode(req.getCode());
        return value;
    }
}