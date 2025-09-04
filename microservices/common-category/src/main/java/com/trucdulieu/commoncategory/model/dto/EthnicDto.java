package com.trucdulieu.commoncategory.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EthnicDto {
    Long id;
    String name;
    String description;
}
