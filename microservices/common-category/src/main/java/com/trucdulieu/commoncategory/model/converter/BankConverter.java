package com.trucdulieu.commoncategory.model.converter;

import com.trucdulieu.commoncategory.model.dto.BankDto;
import com.trucdulieu.commoncategory.model.entity.Bank;

public class BankConverter {
    public static BankDto convertDto(Bank unit) {
        BankDto output = new BankDto();
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        if (unit.getCode() != null) output.setCode(unit.getCode());
        if (unit.getBin() != null) output.setBin(unit.getBin());
        if (unit.getShortName() != null) output.setShortName(unit.getShortName());
        if (unit.getSwiftCode() != null) output.setSwiftCode(unit.getSwiftCode());
        return output;
    }

    public static BankDto convertDto(Bank unit, BankDto output) {
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        if (unit.getCode() != null) output.setCode(unit.getCode());
        if (unit.getBin() != null) output.setBin(unit.getBin());
        if (unit.getShortName() != null) output.setShortName(unit.getShortName());
        if (unit.getSwiftCode() != null) output.setSwiftCode(unit.getSwiftCode());
        return output;
    }

    public static Bank convertEntity(BankDto unit) {
        Bank output = new Bank();
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        if (unit.getCode() != null) output.setCode(unit.getCode());
        if (unit.getBin() != null) output.setBin(unit.getBin());
        if (unit.getShortName() != null) output.setShortName(unit.getShortName());
        if (unit.getSwiftCode() != null) output.setSwiftCode(unit.getSwiftCode());
        return output;
    }

    public static Bank convertEntity(BankDto unit, Bank output) {
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        if (unit.getCode() != null) output.setCode(unit.getCode());
        if (unit.getBin() != null) output.setBin(unit.getBin());
        if (unit.getShortName() != null) output.setShortName(unit.getShortName());
        if (unit.getSwiftCode() != null) output.setSwiftCode(unit.getSwiftCode());
        return output;
    }
}
