package com.trucdulieu.commoncategory.model.converter;

import com.trucdulieu.commoncategory.model.dto.UnitDto;
import com.trucdulieu.commoncategory.model.entity.Unit;

public class UnitConverter {
    public static UnitDto connverDto(Unit unit) {
        UnitDto output = new UnitDto();
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        return output;
    }

    public static UnitDto connverDto(Unit unit,UnitDto output) {
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        return output;
    }
    public static Unit convertEntity(UnitDto unitDto) {
        Unit output= new Unit();
        if (unitDto.getId() != null) output.setId(unitDto.getId());
        if (unitDto.getName() != null) output.setName(unitDto.getName());
        if (unitDto.getDescription() != null) output.setDescription(unitDto.getDescription());
        return output;
    }
    public static Unit convertEntity(UnitDto unitDto, Unit output) {
        if (unitDto.getId() != null)output.setId(unitDto.getId());
        if (unitDto.getName() != null) output.setName(unitDto.getName());
        if (unitDto.getDescription() != null) output.setDescription(unitDto.getDescription());
        return output;
    }
}
