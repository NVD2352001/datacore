package com.trucdulieu.commoncategory.model.converter;

import com.trucdulieu.commoncategory.model.dto.MedicalRouteDto;
import com.trucdulieu.commoncategory.model.entity.MedicalRoute;

public class MedicalRouteConverter {
    public static MedicalRouteDto convertDto(MedicalRoute mr){
        MedicalRouteDto output = new MedicalRouteDto();
        if (mr.getId() != null) output.setId(mr.getId());
        if (mr.getName() != null) output.setName(mr.getName());
        if (mr.getDescription() != null) output.setDescription(mr.getDescription());
        return output;
    }
    public static MedicalRoute convertEntity(MedicalRouteDto mr){
        MedicalRoute output = new MedicalRoute();
        if (mr.getId() != null) output.setId(mr.getId());
        if (mr.getName() != null) output.setName(mr.getName());
        if (mr.getDescription() != null) output.setDescription(mr.getDescription());
        return output;
    }
    public static MedicalRoute convertEntity(MedicalRouteDto mr, MedicalRoute output){
        if (mr.getId() != null) output.setId(mr.getId());
        if (mr.getName() != null) output.setName(mr.getName());
        if (mr.getDescription() != null) output.setDescription(mr.getDescription());
        return output;
    }

}
