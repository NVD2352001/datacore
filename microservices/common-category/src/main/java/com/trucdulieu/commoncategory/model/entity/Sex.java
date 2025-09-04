package com.trucdulieu.commoncategory.model.entity;

import com.trucdulieu.commoncategory.config.EditorObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "commoncategory_gender")
public class Sex extends EditorObject {
    @Column(unique = true)
    private Integer value;
    private Boolean isDefault = false;
}
