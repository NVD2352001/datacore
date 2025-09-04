package com.trucdulieu.commoncategory.model.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRqDto {
    private String name;
    private BigDecimal price;
    private Integer stockCount;
    private Boolean inStock;
}
