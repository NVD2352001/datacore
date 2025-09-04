package com.trucdulieu.commoncategory.model.converter;

import com.trucdulieu.commoncategory.model.dto.GenderDto;
import com.trucdulieu.commoncategory.model.entity.Gender;

public class GenderConverter {
    public static GenderDto connverDto(Gender gender) {
        GenderDto output = new GenderDto();
        if (gender.getId() != null) output.setId(gender.getId());
        if (gender.getName() != null) output.setName(gender.getName());
        if (gender.getDescription() != null) output.setDescription(gender.getDescription());
        return output;
    }

    public static GenderDto connverDto(Gender gender,GenderDto output) {
        if (gender.getId() != null) output.setId(gender.getId());
        if (gender.getName() != null) output.setName(gender.getName());
        if (gender.getDescription() != null) output.setDescription(gender.getDescription());
        return output;
    }
    public static Gender convertGenderEntity(GenderDto genderDto) {
        Gender output= new Gender();
        if (genderDto.getId() != null) output.setId(genderDto.getId());
        if (genderDto.getName() != null) output.setName(genderDto.getName());
        if (genderDto.getDescription() != null) output.setDescription(genderDto.getDescription());
        return output;
    }
    public static Gender convertGenderEntity(GenderDto genderDto, Gender output) {
        if (genderDto.getId() != null)output.setId(genderDto.getId());
        if (genderDto.getName() != null) output.setName(genderDto.getName());
        if (genderDto.getDescription() != null) output.setDescription(genderDto.getDescription());
        return output;
    }


}
