package com.trucdulieu.commoncategory.model.dto;

import com.trucdulieu.commoncategory.model.entity.Bank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankDto {
    Long id;
    String name;
    String description;
    String code;
    String bin;
    String shortName;
    String swiftCode;

    public BankDto(Bank model){
        // Object Mapper
        this.id= model.getId();
        this.name= model.getName();
        this.description= model.getDescription();
        this.code= model.getCode();
        this.bin= model.getBin();
        this.shortName= model.getShortName();
        this.swiftCode= model.getSwiftCode();
    }

}
