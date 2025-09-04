package com.trucdulieu.commoncategory.model.entity;

import javax.persistence.*;

import com.trucdulieu.commoncategory.config.EditorObject;

import lombok.*;

@EqualsAndHashCode(callSuper=true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bank", uniqueConstraints = {
    @UniqueConstraint(columnNames = { "code" }),
    @UniqueConstraint(columnNames = { "short_name" })
})
public class Bank extends EditorObject {
    @Column(name = "code")
    private String code;
    private String bin;
    @Column(name = "short_name")
    private String shortName;
    private String swiftCode;
}
