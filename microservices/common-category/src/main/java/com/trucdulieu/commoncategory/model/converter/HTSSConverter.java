package com.trucdulieu.commoncategory.model.converter;

import com.trucdulieu.commoncategory.model.dto.HTSSDto;
import com.trucdulieu.commoncategory.model.entity.HTSS;

public class HTSSConverter {
    public static HTSSDto convertToDto (HTSS htss){
        HTSSDto htssDto = new HTSSDto();
        if (htss.getId() != null) htssDto.setId(htss.getId());
        if (htss.getCode() != null) htssDto.setCode(htss.getCode());
        if (htss.getName() != null) htssDto.setName(htss.getName());
        if (htss.getDescription() != null) htssDto.setDescription(htss.getDescription());
        return htssDto;
    }
    public static HTSS convertEntity (HTSSDto htssDto){
        HTSS htss = new HTSS();
        if (htssDto.getId() != null) htss.setId(htssDto.getId());
        if (htssDto.getCode() != null) htss.setCode(htssDto.getCode());
        if (htssDto.getName() != null) htss.setName(htssDto.getName());
        if (htssDto.getDescription() != null) htss.setDescription(htssDto.getDescription());
        return htss;
    }
    public static HTSS convertEntity (HTSSDto htssDto, HTSS htss){
        if (htssDto.getId() != null) htss.setId(htssDto.getId());
        if (htssDto.getCode() != null) htss.setCode(htssDto.getCode());
        if (htssDto.getName() != null) htss.setName(htssDto.getName());
        if (htssDto.getDescription() != null) htss.setDescription(htssDto.getDescription());
        return htss;
    }
}
