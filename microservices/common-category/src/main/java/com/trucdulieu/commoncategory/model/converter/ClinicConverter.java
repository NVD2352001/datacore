package com.trucdulieu.commoncategory.model.converter;

import com.trucdulieu.commoncategory.model.dto.ClinicDto;
import com.trucdulieu.commoncategory.model.entity.Clinic;

public class ClinicConverter {
    public static ClinicDto convertDto(Clinic clinic){
        ClinicDto clinicDto = new ClinicDto();
        if (clinic.getId() != null) clinicDto.setId(clinic.getId());
        if (clinic.getName() != null) clinicDto.setName(clinic.getName());
        return clinicDto;
    }
    public static ClinicDto convertDto(Clinic clinic, ClinicDto clinicDto){
        if (clinic.getId() != null) clinicDto.setId(clinic.getId());
        if (clinic.getName() != null) clinicDto.setName(clinic.getName());
        return clinicDto;
    }
    public static Clinic convertEntity(ClinicDto clinicDto) {
        Clinic clinic = new Clinic();
        if (clinicDto.getId() != null) clinic.setId(clinicDto.getId());
        if (clinicDto.getName() != null ) clinic.setName(clinicDto.getName());
        return clinic;
    }
    public static Clinic convertEntity(ClinicDto clinicDto, Clinic clinic){
        if (clinicDto.getId() != null) clinic.setId(clinicDto.getId());
        if (clinicDto.getName() != null) clinic.setName(clinicDto.getName());
        return clinic;
    }
}
