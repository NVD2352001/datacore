package com.trucdulieu.commoncategory.model.entity;

import com.trucdulieu.commoncategory.config.EditorObject;
import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "medical_supplies", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name"})
})
public class MedicalSupplies extends EditorObject {
    private String insuranceCode;
    private String nameByInsurance;
    //mã hàng
    private String PLU;
    //quy cách
    private String prescribedManner;
    private String medicalSuppliesGroup;
    private String manufacturingCountry;
    private String manufacturer;
//    @OneToOne
//    @JoinColumn(name = "fk_unitId")
//    private Unit unit;
    private Boolean healthInsurancePay;
    private String technicalCriteriaGroup;
    private String successfulBidder;
}
