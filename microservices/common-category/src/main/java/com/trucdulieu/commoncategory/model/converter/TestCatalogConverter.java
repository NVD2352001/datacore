package com.trucdulieu.commoncategory.model.converter;

import com.trucdulieu.commoncategory.model.dto.TestCatalogDto;
import com.trucdulieu.commoncategory.model.entity.TestCatalog;

public class TestCatalogConverter {
    public static TestCatalogDto convertDto(TestCatalog unit){
        TestCatalogDto output = new TestCatalogDto();
        if(unit.getId() != null) output.setId(unit.getId());
        if(unit.getName() != null) output.setName(unit.getName());
        if(unit.getDescription() != null) output.setDescription(unit.getDescription());
        if(unit.getCode() != null) output.setCode(unit.getCode());
        if(unit.getIndex() != null) output.setIndex(unit.getIndex());
        return output;
    }

    public static TestCatalog convertEntity(TestCatalogDto unit){
        TestCatalog output = new TestCatalog();
        if(unit.getId() != null) output.setId(unit.getId());
        if(unit.getName() != null) output.setName(unit.getName());
        if(unit.getDescription() != null) output.setDescription(unit.getDescription());
        if(unit.getCode() != null) output.setCode(unit.getCode());
        if(unit.getIndex() != null) output.setIndex(unit.getIndex());
        return output;
    }

    public static TestCatalog convertEntity(TestCatalogDto unit, TestCatalog output){
        if(unit.getId() != null) output.setId(unit.getId());
        if(unit.getName() != null) output.setName(unit.getName());
        if(unit.getDescription() != null) output.setDescription(unit.getDescription());
        if(unit.getCode() != null) output.setCode(unit.getCode());
        if(unit.getIndex() != null) output.setIndex(unit.getIndex());
        return output;
    }

}
