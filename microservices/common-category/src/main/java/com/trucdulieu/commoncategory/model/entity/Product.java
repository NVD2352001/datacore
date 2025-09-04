package com.trucdulieu.commoncategory.model.entity;

import lombok.*;

import javax.persistence.*;

import com.trucdulieu.commoncategory.config.EditorObject;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends EditorObject{
    private String ref;
    private BigDecimal price;
    private Integer stockCount;
    private Boolean inStock;
}
