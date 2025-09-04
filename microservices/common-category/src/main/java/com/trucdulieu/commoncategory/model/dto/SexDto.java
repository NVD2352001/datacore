package com.trucdulieu.commoncategory.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SexDto {

    private Long id;
    private String name;
    private Integer value;
    private String description;
    private Boolean isDefault;
}
