package com.trucdulieu.commoncategory.model.entity;

import com.trucdulieu.commoncategory.config.EditorObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper=true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "test_index")
public class TestIndex extends EditorObject {
    private Double referenceValue;
    private Double unit;
}
