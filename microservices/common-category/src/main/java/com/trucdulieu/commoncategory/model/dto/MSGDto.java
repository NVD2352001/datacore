package com.trucdulieu.commoncategory.model.dto;

import com.trucdulieu.commoncategory.model.entity.MSG;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MSGDto {
    private Long id;
    private String name;
    private String code;
    private String description;

    public MSGDto (MSG model){
        this.id = model.getId();
        this.name = model.getName();
        this.code = model.getCode();
        this.description = model.getDescription();
    }
}
