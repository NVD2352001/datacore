package com.trucdulieu.commoncategory.model.dto;

import com.trucdulieu.commoncategory.model.entity.Ward;

import lombok.*;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WardDto {

    private Long id;
    private String name;
    private String description;

    public WardDto(Ward model) {
        this.id = model.getId();
        this.name = model.getName();
        this.description = model.getDescription();
    }
}