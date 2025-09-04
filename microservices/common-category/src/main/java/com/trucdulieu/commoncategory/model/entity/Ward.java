package com.trucdulieu.commoncategory.model.entity;

import lombok.*;

import javax.persistence.*;

import com.trucdulieu.commoncategory.config.EditorObject;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "wardd")
public class Ward extends EditorObject {
}
