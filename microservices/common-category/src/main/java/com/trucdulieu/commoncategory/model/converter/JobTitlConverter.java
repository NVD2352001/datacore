package com.trucdulieu.commoncategory.model.converter;


import com.trucdulieu.commoncategory.model.dto.JobTitlDto;
import com.trucdulieu.commoncategory.model.entity.JobTitl;

public class JobTitlConverter {
    public static JobTitlDto convertDto(JobTitl unit) {
        JobTitlDto output = new JobTitlDto();
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        return output;
    }

    public static JobTitlDto convertDto(JobTitl unit, JobTitlDto output) {
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        return output;
    }

    public static JobTitl convertEntity(JobTitlDto unit) {
        JobTitl output = new JobTitl();
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        return output;
    }

    public static JobTitl convertEntity(JobTitlDto unit, JobTitl output) {
        if (unit.getId() != null) output.setId(unit.getId());
        if (unit.getName() != null) output.setName(unit.getName());
        if (unit.getDescription() != null) output.setDescription(unit.getDescription());
        return output;
    }

}
