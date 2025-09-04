package com.trucdulieu.commoncategory.model.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenderDto {
    private Long id;
    private String name;
    private String description;
}
