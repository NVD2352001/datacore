package com.trucdulieu.commoncategory.model.converter;

import com.trucdulieu.commoncategory.model.dto.EthnicDto;
import com.trucdulieu.commoncategory.model.entity.Ethnic;

public class EthnicConverter {
    public static EthnicDto convertDto(Ethnic unit){
        EthnicDto output = new EthnicDto();
        if(unit.getId() != null) output.setId(unit.getId());
        if(unit.getName()!= null) output.setName(unit.getName());
        if(unit.getDescription() != null) output.setDescription(unit.getDescription());
        return output;
    }

    public static Ethnic convertEntity(EthnicDto unit){
        Ethnic output = new Ethnic();
        if(unit.getId() != null) output.setId(unit.getId());
        if(unit.getName() != null) output.setName(unit.getName());
        if(unit.getDescription() != null) output.setDescription(unit.getDescription());
        return output;
    }

    public static Ethnic convertEntity(EthnicDto unit, Ethnic output){
        if(unit.getId() != null) output.setId(unit.getId());
        if(unit.getName() != null) output.setName(unit.getName());
        if(unit.getDescription() != null) output.setDescription(unit.getDescription());
        return output;
    }
}
