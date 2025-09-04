package com.trucdulieu.commoncategory.model.converter;

import com.trucdulieu.commoncategory.model.dto.DistrictDto;
import com.trucdulieu.commoncategory.model.entity.District;

public class DistrictConverter {
    public static DistrictDto convertDto(District unit){
        DistrictDto output = new DistrictDto();
        if(unit.getId() != null) output.setId(unit.getId());
        if(unit.getName() != null) output.setName(unit.getName());
        if(unit.getDescription() != null) output.setDescription(unit.getDescription());
        if(unit.getIdCity() != null) output.setIdCity(unit.getIdCity());
        return output;
    }

    public static District convertEntity(DistrictDto unit){
        District output = new District();
        if(unit.getId() != null) output.setId(unit.getId());
        if(unit.getName() != null) output.setName(unit.getName());
        if(unit.getDescription() != null) output.setDescription(unit.getDescription());
        if(unit.getIdCity() != null) output.setIdCity(unit.getIdCity());
        return output;
    }

    public static District convertEntity(DistrictDto unit, District output){
        if(unit.getId() != null) output.setId(unit.getId());
        if(unit.getName() != null) output.setName(unit.getName());
        if(unit.getDescription() != null) output.setDescription(unit.getDescription());
        if(unit.getIdCity() != null) output.setIdCity(unit.getIdCity());
        return output;
    }

}
