package com.trucdulieu.commoncategory.model.converter;


import com.trucdulieu.commoncategory.model.dto.DiagnosticImagingDto;
import com.trucdulieu.commoncategory.model.entity.DiagnosticImaging;

public class DiagnosticImagingConverter {
    public static DiagnosticImagingDto convertDto(DiagnosticImaging unit) {
        DiagnosticImagingDto output = new DiagnosticImagingDto();
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        return output;
    }

    public static DiagnosticImagingDto convertDto(DiagnosticImaging unit, DiagnosticImagingDto output) {
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        return output;
    }

    public static DiagnosticImaging convertEntity(DiagnosticImagingDto unit) {
        DiagnosticImaging output = new DiagnosticImaging();
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        return output;
    }

    public static DiagnosticImaging convertEntity(DiagnosticImagingDto unit, DiagnosticImaging output) {
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        return output;
    }
}
