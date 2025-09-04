package com.trucdulieu.commoncategory.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestIndexDto {
    Long id;
    String name;
    String description;
    private Double referenceValue;
    private Double unit;
}
