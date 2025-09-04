package com.trucdulieu.commoncategory.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MedicalSuppliesDto {
    private Long id;
    private String name;
    private String description;

    private String insuranceCode;
    private String nameByInsurance;
    private String PLU;
    private String prescribedManner;
    private String medicalSuppliesGroup;
    private String manufacturingCountry;
    private String manufacturer;
    private String unit;
    private Boolean healthInsurancePay;
    private String technicalCriteriaGroup;
    private String successfulBidder;

    private String createdAt;
    private String updatedAt;
    private String createdBy;
    private String updatedBy;
}
