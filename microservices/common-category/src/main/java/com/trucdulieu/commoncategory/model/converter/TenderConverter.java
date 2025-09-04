package com.trucdulieu.commoncategory.model.converter;

import com.trucdulieu.commoncategory.model.dto.TenderDecisionDto;
import com.trucdulieu.commoncategory.model.entity.TenderDecision;

public class TenderConverter {
    public static TenderDecisionDto convertDto(TenderDecision unit) {
        TenderDecisionDto output = new TenderDecisionDto();
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        if (unit.getUnit() != null) output.setUnit(unit.getUnit());
        if (unit.getTenderNumber() != null) output.setTenderNumber(unit.getTenderNumber());
        if (unit.getDecision() != null) output.setDecision(unit.getDecision());
        if (unit.getDecisionDate() != null) output.setDecisionDate(unit.getDecisionDate());
        return output;
    }


    public static TenderDecision convertEntity(TenderDecisionDto unit) {
        TenderDecision output = new TenderDecision();
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        if (unit.getUnit() != null) output.setUnit(unit.getUnit());
        if (unit.getTenderNumber() != null) output.setTenderNumber(unit.getTenderNumber());
        if (unit.getDecision() != null) output.setDecision(unit.getDecision());
        if (unit.getDecisionDate() != null) output.setDecisionDate(unit.getDecisionDate());
        return output;
    }

    public static TenderDecision convertEntity(TenderDecisionDto unit, TenderDecision output) {
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        if (unit.getUnit() != null) output.setUnit(unit.getUnit());
        if (unit.getTenderNumber() != null) output.setTenderNumber(unit.getTenderNumber());
        if (unit.getDecision() != null) output.setDecision(unit.getDecision());
        if (unit.getDecisionDate() != null) output.setDecisionDate(unit.getDecisionDate());
        return output;
    }
}
