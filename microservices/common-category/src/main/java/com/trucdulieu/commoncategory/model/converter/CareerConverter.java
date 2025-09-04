package com.trucdulieu.commoncategory.model.converter;


import com.trucdulieu.commoncategory.model.dto.CareerDto;
import com.trucdulieu.commoncategory.model.entity.Career;

public class CareerConverter {
    public static CareerDto convertDto(Career unit) {
        CareerDto output = new CareerDto();
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        return output;
    }

    public static CareerDto convertDto(Career unit, CareerDto output) {
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        return output;
    }

    public static Career convertEntity(CareerDto unit) {
        Career output = new Career();
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        return output;
    }

    public static Career convertEntity(CareerDto unit, Career output) {
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        return output;
    }
}
