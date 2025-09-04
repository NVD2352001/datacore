package com.trucdulieu.commoncategory.model.converter;

import com.trucdulieu.commoncategory.model.dto.MedicalRecordTemplateDto;
import com.trucdulieu.commoncategory.model.entity.MedicalRecordTemplate;

public class MedicalRecordTemplateConverter {
    public static MedicalRecordTemplateDto convertDto(MedicalRecordTemplate medicalRecordTemplate){
        MedicalRecordTemplateDto medicalRecordTemplateDto = new MedicalRecordTemplateDto();
        if (medicalRecordTemplate.getId() != null) medicalRecordTemplateDto.setId(medicalRecordTemplate.getId());
        if (medicalRecordTemplate.getName() != null) medicalRecordTemplateDto.setName(medicalRecordTemplate.getName());
        if (medicalRecordTemplate.getDescription() != null) medicalRecordTemplateDto.setDescription(medicalRecordTemplate.getDescription());
        return medicalRecordTemplateDto;
    }
    public static MedicalRecordTemplateDto convertDto(MedicalRecordTemplate medicalRecordTemplate, MedicalRecordTemplateDto medicalRecordTemplateDto){
        if (medicalRecordTemplate.getId() != null) medicalRecordTemplateDto.setId(medicalRecordTemplate.getId());
        if (medicalRecordTemplate.getName() != null) medicalRecordTemplateDto.setName(medicalRecordTemplate.getName());
        if (medicalRecordTemplate.getDescription() != null) medicalRecordTemplateDto.setDescription(medicalRecordTemplate.getDescription());
        return medicalRecordTemplateDto;
    }
    public static MedicalRecordTemplate convertEntity(MedicalRecordTemplateDto medicalRecordTemplateDto) {
        MedicalRecordTemplate medicalRecordTemplate = new MedicalRecordTemplate();
        if (medicalRecordTemplateDto.getId() != null) medicalRecordTemplate.setId(medicalRecordTemplateDto.getId());
        if (medicalRecordTemplateDto.getName() != null ) medicalRecordTemplate.setName(medicalRecordTemplateDto.getName());
        if (medicalRecordTemplateDto.getDescription() != null) medicalRecordTemplate.setDescription(medicalRecordTemplateDto.getDescription());
        return medicalRecordTemplate;
    }
    public static MedicalRecordTemplate convertEntity(MedicalRecordTemplateDto medicalRecordTemplateDto, MedicalRecordTemplate medicalRecordTemplate){
        if (medicalRecordTemplateDto.getId() != null) medicalRecordTemplate.setId(medicalRecordTemplateDto.getId());
        if (medicalRecordTemplateDto.getName() != null) medicalRecordTemplate.setName(medicalRecordTemplateDto.getName());
        if (medicalRecordTemplateDto.getDescription() != null) medicalRecordTemplate.setDescription(medicalRecordTemplateDto.getDescription());
        return medicalRecordTemplate;
    }
}
