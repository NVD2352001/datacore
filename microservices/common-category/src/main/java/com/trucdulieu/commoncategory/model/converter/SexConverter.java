package com.trucdulieu.commoncategory.model.converter;

import com.trucdulieu.commoncategory.model.dto.SexDto;
import com.trucdulieu.commoncategory.model.entity.Sex;

public class SexConverter {
    public static SexDto convertDto(Sex unit) {
        SexDto output = new SexDto();
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getValue() != null) output.setValue(unit.getValue());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        if (unit.getIsDefault() != null) output.setIsDefault(unit.getIsDefault());
        return output;
    }

    public static Sex convertEntity(SexDto unit) {
        Sex output = new Sex();
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getValue() != null) output.setValue(unit.getValue());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        if (unit.getIsDefault() != null) output.setIsDefault(unit.getIsDefault());
        return output;
    }

    public static Sex convertEntity(SexDto unit, Sex output) {
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getValue() != null) output.setValue(unit.getValue());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        if (unit.getIsDefault() != null) output.setIsDefault(unit.getIsDefault());
        return output;
    }
}
