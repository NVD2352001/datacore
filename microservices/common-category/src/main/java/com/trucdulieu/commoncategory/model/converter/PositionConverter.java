package com.trucdulieu.commoncategory.model.converter;
import com.trucdulieu.commoncategory.model.dto.PositionDto;
import com.trucdulieu.commoncategory.model.entity.Position;

public class PositionConverter {
    public static PositionDto convertDto(Position unit) {
        PositionDto output = new PositionDto();
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        return output;
    }

    public static PositionDto convertDto(Position unit, PositionDto output) {
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        return output;
    }

    public static Position convertEntity(PositionDto unit) {
        Position output = new Position();
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        return output;
    }

    public static Position convertEntity(PositionDto unit, Position output) {
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        return output;
    }
}
