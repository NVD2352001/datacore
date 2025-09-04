package com.trucdulieu.commoncategory.model.entity;


import com.trucdulieu.commoncategory.config.EditorObject;
import lombok.*;

import javax.persistence.*;

@Entity
@EqualsAndHashCode(callSuper=true)
@Data
@Table(name = "districts")
public class District extends EditorObject {
    @Column(name = "id_city")
    private Long idCity;
}
