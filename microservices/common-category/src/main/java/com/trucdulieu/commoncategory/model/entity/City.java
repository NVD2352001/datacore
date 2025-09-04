package com.trucdulieu.commoncategory.model.entity;

import com.trucdulieu.commoncategory.config.EditorObject;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "city", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name"})
})
public class City extends EditorObject {
    @Column(name = "regions")
    private String regions;
    @Column(name = "zipcode")
    private Integer zipCode;
}
