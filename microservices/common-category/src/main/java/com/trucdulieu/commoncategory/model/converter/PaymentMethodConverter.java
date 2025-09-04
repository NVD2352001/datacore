package com.trucdulieu.commoncategory.model.converter;

import com.trucdulieu.commoncategory.model.dto.PaymentMethodDto;
import com.trucdulieu.commoncategory.model.entity.PaymentMethod;

public class PaymentMethodConverter {
    public static PaymentMethodDto convertDto(PaymentMethod unit) {
        PaymentMethodDto output = new PaymentMethodDto();
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        return output;
    }

    public static PaymentMethodDto convertDto(PaymentMethod unit, PaymentMethodDto output) {
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        return output;
    }

    public static PaymentMethod convertEntity(PaymentMethodDto unit) {
        PaymentMethod output = new PaymentMethod();
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        return output;
    }

    public static PaymentMethod convertEntity(PaymentMethodDto unit, PaymentMethod output) {
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        return output;
    }
}
