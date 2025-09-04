package com.trucdulieu.commoncategory.model.converter;

import com.trucdulieu.commoncategory.model.dto.Icd10Dto;
import com.trucdulieu.commoncategory.model.entity.Icd10;

public class Icd10Converter {
    public static Icd10Dto connverDto(Icd10 icd10) {
        Icd10Dto output = new Icd10Dto();
        if (icd10.getId() != null) output.setId(icd10.getId());
        if (icd10.getName() != null) output.setName(icd10.getName());
        if (icd10.getCode() != null) output.setCode(icd10.getCode());
        if (icd10.getChapter() != null) output.setChapter(icd10.getChapter());
        if (icd10.getGroups() != null) output.setGroups(icd10.getGroups());
        return output;
    }

    public static Icd10Dto connverDto(Icd10 icd10, Icd10Dto output) {
        if (icd10.getId() != null) output.setId(icd10.getId());
        if (icd10.getName() != null) output.setName(icd10.getName());
        if (icd10.getCode() != null) output.setCode(icd10.getCode());
        if (icd10.getChapter() != null) output.setCode(icd10.getChapter());
        if (icd10.getGroups() != null) output.setCode(icd10.getGroups());
        return output;
    }
    public static Icd10 convertEntity(Icd10Dto icd10Dto) {
        Icd10 output= new Icd10();
        if (icd10Dto.getId() != null) output.setId(icd10Dto.getId());
        if (icd10Dto.getName() != null) output.setName(icd10Dto.getName());
        if (icd10Dto.getCode() != null) output.setName(icd10Dto.getCode());
        if (icd10Dto.getChapter() != null) output.setName(icd10Dto.getChapter());
        if (icd10Dto.getGroups() != null) output.setName(icd10Dto.getGroups());
        return output;
    }
    public static Icd10 convertEntity(Icd10Dto icd10Dto, Icd10 output) {
        if (icd10Dto.getId() != null) output.setId(icd10Dto.getId());
        if (icd10Dto.getName() != null) output.setName(icd10Dto.getName());
        if (icd10Dto.getCode() != null) output.setName(icd10Dto.getCode());
        if (icd10Dto.getChapter() != null) output.setName(icd10Dto.getChapter());
        if (icd10Dto.getGroups() != null) output.setName(icd10Dto.getGroups());
        return output;
    }
}
