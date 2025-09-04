package com.trucdulieu.commoncategory.model.dto;

import com.trucdulieu.commoncategory.model.entity.MedicalRoute;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalRouteDto {
    private Long id;
    private String name;
    private String description;

public MedicalRouteDto (MedicalRoute model){
    this.id = model.getId();
    this.name = model.getName();
    this.description = model.getDescription();
    }
}
