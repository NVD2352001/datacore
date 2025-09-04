package com.trucdulieu.commoncategory.model.converter;

import com.trucdulieu.commoncategory.model.dto.ChemicalInteractionDto;
import com.trucdulieu.commoncategory.model.entity.ChemicalInteraction;

public class ChemicalInteractionConverter {
    public static ChemicalInteractionDto convertDto(ChemicalInteraction unit) {
        ChemicalInteractionDto output = new ChemicalInteractionDto();
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        if (unit.getCode() != null) output.setCode(unit.getCode());
        if (unit.getInteraction() != null) output.setInteraction(unit.getInteraction());
        if (unit.getCreator() != null) output.setCreator(unit.getCreator());
        return output;
    }

    public static ChemicalInteraction convertEntity(ChemicalInteractionDto unit) {
        ChemicalInteraction output = new ChemicalInteraction();
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        if (unit.getCode() != null) output.setCode(unit.getCode());
        if (unit.getInteraction() != null) output.setInteraction(unit.getInteraction());
        if (unit.getCreator() != null) output.setCreator(unit.getCreator());
        return output;
    }

    public static ChemicalInteraction convertEntity(ChemicalInteractionDto unit, ChemicalInteraction output) {
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        if (unit.getCode() != null) output.setCode(unit.getCode());
        if (unit.getInteraction() != null) output.setInteraction(unit.getInteraction());
        if (unit.getCreator() != null) output.setCreator(unit.getCreator());
        return output;
    }
}
