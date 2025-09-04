package com.trucdulieu.commoncategory.model.converter;


import com.trucdulieu.commoncategory.model.dto.ImageDiagnosticMachineDto;
import com.trucdulieu.commoncategory.model.entity.ImageDiagnosticMachine;

public class ImageDiagnosticMachineConverter {
    public static ImageDiagnosticMachineDto convertDto(ImageDiagnosticMachine unit) {
        ImageDiagnosticMachineDto output = new ImageDiagnosticMachineDto();
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        if (unit.getCode() != null) output.setCode(unit.getCode());
        return output;
    }

    public static ImageDiagnosticMachineDto convertDto(ImageDiagnosticMachine unit, ImageDiagnosticMachineDto output) {
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        if (unit.getCode() != null) output.setCode(unit.getCode());
        return output;
    }

    public static ImageDiagnosticMachine convertEntity(ImageDiagnosticMachineDto unit) {
        ImageDiagnosticMachine output = new ImageDiagnosticMachine();
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        if (unit.getCode() != null) output.setCode(unit.getCode());
        return output;
    }

    public static ImageDiagnosticMachine convertEntity(ImageDiagnosticMachineDto unit, ImageDiagnosticMachine output) {
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        if (unit.getCode() != null) output.setCode(unit.getCode());
        return output;
    }
}
