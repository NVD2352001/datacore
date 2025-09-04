package com.trucdulieu.commoncategory.model.dto;

import com.trucdulieu.commoncategory.model.entity.HTSS;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HTSSDto {
    private Long id;
    private String name;
    private String description;
    private String code;

    @SuppressWarnings("unused")
    private HTSSDto (HTSS model){
        this.id = model.getId();
        this.name = model.getName();
        this.description = model.getDescription();
        this.code = model.getCode();
    }
}
