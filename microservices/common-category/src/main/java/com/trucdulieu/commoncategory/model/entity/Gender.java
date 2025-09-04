package com.trucdulieu.commoncategory.model.entity;

import com.trucdulieu.commoncategory.config.EditorObject;
import lombok.*;


import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@Entity
@Table(name = "genders")
public class Gender extends EditorObject {
}
