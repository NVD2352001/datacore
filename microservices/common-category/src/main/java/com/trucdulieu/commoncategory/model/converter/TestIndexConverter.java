package com.trucdulieu.commoncategory.model.converter;


import com.trucdulieu.commoncategory.model.dto.TestIndexDto;
import com.trucdulieu.commoncategory.model.entity.TestIndex;

public class TestIndexConverter {
    public static TestIndexDto convertDto(TestIndex unit) {
        TestIndexDto output = new TestIndexDto();
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        if (unit.getReferenceValue() != null) output.setReferenceValue(unit.getReferenceValue());
        if (unit.getUnit() != null) output.setUnit(unit.getUnit());
        return output;
    }

    public static TestIndexDto convertDto(TestIndex unit, TestIndexDto output) {
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        if (unit.getReferenceValue() != null) output.setReferenceValue(unit.getReferenceValue());
        if (unit.getUnit() != null) output.setUnit(unit.getUnit());
        return output;
    }

    public static TestIndex convertEntity(TestIndexDto unit) {
        TestIndex output = new TestIndex();
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        if (unit.getReferenceValue() != null) output.setReferenceValue(unit.getReferenceValue());
        if (unit.getUnit() != null) output.setUnit(unit.getUnit());
        return output;
    }

    public static TestIndex convertEntity(TestIndexDto unit, TestIndex output) {
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        if (unit.getReferenceValue() != null) output.setReferenceValue(unit.getReferenceValue());
        if (unit.getUnit() != null) output.setUnit(unit.getUnit());
        return output;
    }
}
