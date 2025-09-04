package com.trucdulieu.commoncategory.model.entity;

import com.trucdulieu.commoncategory.config.EditorObject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper=true)
@Data
@Entity
@Table(name = "department")
public class Department extends EditorObject {
}
