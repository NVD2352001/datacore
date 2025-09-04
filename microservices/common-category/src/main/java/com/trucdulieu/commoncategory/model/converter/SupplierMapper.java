package com.trucdulieu.commoncategory.model.converter;

import com.trucdulieu.commoncategory.model.dto.SupplierDto;
import com.trucdulieu.commoncategory.model.entity.Supplier;

public class SupplierMapper {

    public static SupplierDto toDTO(Supplier supplier) {
        return SupplierDto.builder()
                .id(supplier.getId())
                .name(supplier.getName())
                .description(supplier.getDescription())
                .address(supplier.getAddress())
                .contact(supplier.getContact())
                .note(supplier.getNote())
                .build();
    }

    public static Supplier forUpdate(Supplier value, SupplierDto req) {
        if (req.getName() != null)
            value.setName(req.getName());
        if (req.getDescription() != null)
            value.setDescription(req.getDescription());
        if (req.getAddress() != null)
            value.setAddress(req.getAddress());
        if (req.getContact() != null)
            value.setContact(req.getContact());
        if (req.getNote() != null)
            value.setNote(req.getNote());
        return value;
    }
}
