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
@Table(name = "tender_decision")
public class TenderDecision extends EditorObject {
    @Column(name = "unit_name")
    private String unit;
    @Column(name = "tender_number")
    private String tenderNumber;
    @Column(name = "decision")
    private String decision;
    @Column(name = "decision_date")
    private String decisionDate;
}
