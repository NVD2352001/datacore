package com.trucdulieu.commoncategory.model.entity;

import com.trucdulieu.commoncategory.config.EditorObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@EqualsAndHashCode(callSuper=true)
@Data
@Table(name = "ethnics")
public class Ethnic extends EditorObject {
}
