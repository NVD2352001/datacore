package com.trucdulieu.commoncategory.model.entity;

import com.trucdulieu.commoncategory.config.EditorObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper=true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chemical_interaction")
public class ChemicalInteraction extends EditorObject {
    @Column(name = "code")
    private String code;
    @Column(name = "interaction")
    private String interaction;
    @Column(name = "creator")
    private String creator;
}
