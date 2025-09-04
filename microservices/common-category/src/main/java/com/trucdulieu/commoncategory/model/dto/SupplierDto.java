package com.trucdulieu.commoncategory.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SupplierDto {
    private Long id;
    private String name;
    private String description;
    private String address;
    private String contact;
    private String note;
//    private String createdAt;
//    private String updatedAt;
//    private String createdBy;
//    private String updatedBy;
}
