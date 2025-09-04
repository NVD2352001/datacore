package com.trucdulieu.commoncategory.model.entity;

import com.trucdulieu.commoncategory.config.EditorObject;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "supplier",
       uniqueConstraints = {
                @UniqueConstraint(columnNames = {"name"})
       })
public class Supplier extends EditorObject {
    private String address;
    private String contact;
    private String note;
}
