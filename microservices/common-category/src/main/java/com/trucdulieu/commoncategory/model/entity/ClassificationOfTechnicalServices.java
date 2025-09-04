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
@Table(name = "classification_technical_services",
       uniqueConstraints = {
                @UniqueConstraint(columnNames = {"name"})
       })
//phân loại dịch dụ kỹ thuật
public class ClassificationOfTechnicalServices extends EditorObject {
    private String code;
}
