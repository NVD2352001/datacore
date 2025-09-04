package com.trucdulieu.commoncategory.model.converter;

import com.trucdulieu.commoncategory.model.dto.KCBTDto;
import com.trucdulieu.commoncategory.model.entity.KCBT;

public class KCBTConverter {
    public static KCBTDto convertDto(KCBT kcbt){
        KCBTDto output = new KCBTDto();
        if (kcbt.getId() != null) output.setId(kcbt.getId());
        if (kcbt.getName() != null) output.setName(kcbt.getName());
        if (kcbt.getDescription() != null) output.setDescription(kcbt.getDescription());
        return output;
    }
    public static KCBT convertEntity(KCBTDto kcbt){
        KCBT output = new KCBT();
        if (kcbt.getId() != null) output.setId(kcbt.getId());
        if (kcbt.getName() != null) output.setName(kcbt.getName());
        if (kcbt.getDescription() != null) output.setDescription(kcbt.getDescription());
        return output;
    }
    public static KCBT convertEntity(KCBTDto kcbt, KCBT output){
        if (kcbt.getId() != null) output.setId(kcbt.getId());
        if (kcbt.getName() != null) output.setName(kcbt.getName());
        if (kcbt.getDescription() != null) output.setDescription(kcbt.getDescription());
        return output;
    }
}
