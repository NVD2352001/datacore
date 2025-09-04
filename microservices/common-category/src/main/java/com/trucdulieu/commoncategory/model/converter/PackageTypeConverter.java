package com.trucdulieu.commoncategory.model.converter;
import com.trucdulieu.commoncategory.model.dto.PackageTypeDto;
import com.trucdulieu.commoncategory.model.entity.PackageType;

public class PackageTypeConverter {
    public static PackageTypeDto convertDto(PackageType unit) {
        PackageTypeDto output = new PackageTypeDto();
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        if (unit.getCode() != null) output.setCode(unit.getCode());
        return output;
    }

    public static PackageType convertEntity(PackageTypeDto unit) {
        PackageType output = new PackageType();
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        if (unit.getCode() != null) output.setCode(unit.getCode());
        return output;
    }

    public static PackageType convertEntity(PackageTypeDto unit, PackageType output) {
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        if (unit.getCode() != null) output.setCode(unit.getCode());
        return output;
    }
}
