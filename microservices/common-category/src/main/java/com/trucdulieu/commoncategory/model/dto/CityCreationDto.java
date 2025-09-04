package com.trucdulieu.commoncategory.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CityCreationDto {
    private Long id;
    private String name;
    private String description;
    private String regions;
    private Integer zipCode;
}
