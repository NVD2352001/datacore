package com.trucdulieu.commoncategory.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChemicalInteractionDto {
    Long id;
    String name;
    String description;
    String code;
    String interaction;
    String creator;
}
