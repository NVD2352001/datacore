package com.trucdulieu.commoncategory.model.converter;

import com.trucdulieu.commoncategory.model.dto.SubjectsOfMedicalExaminationAndTreatmentDto;
import com.trucdulieu.commoncategory.model.entity.SubjectsOfMedicalExaminationAndTreatment;

public class SubjectsOfMedicalExaminationAndTreatmentConverter {
    public static SubjectsOfMedicalExaminationAndTreatmentDto connverDto(SubjectsOfMedicalExaminationAndTreatment model) {
        SubjectsOfMedicalExaminationAndTreatmentDto output = new SubjectsOfMedicalExaminationAndTreatmentDto();
        if (model.getId() != null) output.setId(model.getId());
        if (model.getName() != null) output.setName(model.getName());
        if (model.getDescription() != null) output.setDescription(model.getDescription());
        return output;
    }

    public static SubjectsOfMedicalExaminationAndTreatmentDto connverDto(SubjectsOfMedicalExaminationAndTreatment model,SubjectsOfMedicalExaminationAndTreatmentDto dto) {
        if (model.getId() != null) dto.setId(model.getId());
        if (model.getName() != null) dto.setName(model.getName());
        if (model.getDescription() != null) dto.setDescription(model.getDescription());
        return dto;
    }
    public static SubjectsOfMedicalExaminationAndTreatment convertEntity(SubjectsOfMedicalExaminationAndTreatmentDto dto) {
        SubjectsOfMedicalExaminationAndTreatment output= new SubjectsOfMedicalExaminationAndTreatment();
        if (dto.getId() != null) output.setId(dto.getId());
        if (dto.getName() != null) output.setName(dto.getName());
        if (dto.getDescription() != null) output.setDescription(dto.getDescription());
        return output;
    }
    public static SubjectsOfMedicalExaminationAndTreatment convertEntity(SubjectsOfMedicalExaminationAndTreatmentDto dto, SubjectsOfMedicalExaminationAndTreatment model) {
        if (dto.getId() != null)model.setId(dto.getId());
        if (dto.getName() != null) model.setName(dto.getName());
        if (dto.getDescription() != null) model.setDescription(dto.getDescription());
        return model;
    }

}
