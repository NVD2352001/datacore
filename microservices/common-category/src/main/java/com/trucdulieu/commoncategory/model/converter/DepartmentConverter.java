package com.trucdulieu.commoncategory.model.converter;

import com.trucdulieu.commoncategory.model.dto.DepartmentDto;
import com.trucdulieu.commoncategory.model.entity.Department;

public class DepartmentConverter {
    public static DepartmentDto convertDto(Department unit) {
        DepartmentDto output = new DepartmentDto();
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        return output;
    }

    public static Department convertEntity(DepartmentDto unit) {
        Department output = new Department();
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        return output;
    }

    public static Department convertEntity(DepartmentDto unit, Department output) {
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        return output;
    }
}
