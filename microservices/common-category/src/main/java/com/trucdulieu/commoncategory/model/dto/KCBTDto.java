package com.trucdulieu.commoncategory.model.dto;

import com.trucdulieu.commoncategory.model.entity.KCBT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KCBTDto {
    private Long id;
    private String name;
    private String description;

    @SuppressWarnings("unused")
    private KCBTDto (KCBT model){
        this.id = model.getId();
        this.name = model.getName();
        this.description = model.getDescription();
    }
}
