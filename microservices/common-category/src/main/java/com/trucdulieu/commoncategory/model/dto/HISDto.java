package com.trucdulieu.commoncategory.model.dto;

import com.trucdulieu.commoncategory.model.entity.HIS;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HISDto {

    private Long id;
    private String name;

    @SuppressWarnings("unused")
    private HISDto (HIS model){
        this.id = model.getId();
        this.name = model.getName();
    }
}
