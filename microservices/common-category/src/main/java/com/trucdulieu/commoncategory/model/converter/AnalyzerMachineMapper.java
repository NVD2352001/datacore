package com.trucdulieu.commoncategory.model.converter;

import com.trucdulieu.commoncategory.model.dto.AnalyzerMachineDto;
import com.trucdulieu.commoncategory.model.entity.AnalyzerMachine;

public class AnalyzerMachineMapper {

    public static AnalyzerMachineDto toDTO(AnalyzerMachine analyzerMachine) {
        return AnalyzerMachineDto.builder()
                .id(analyzerMachine.getId())
                .name(analyzerMachine.getName())
                .description(analyzerMachine.getDescription())
                .machineCode(analyzerMachine.getMachineCode())
                .createdAt(analyzerMachine.getCreatedAt())
                .updatedAt(analyzerMachine.getUpdatedAt())
                .createdBy(analyzerMachine.getCreatedBy())
                .updatedBy(analyzerMachine.getUpdatedBy())
                .build();
    }

    public static AnalyzerMachine forUpdate(AnalyzerMachine output, AnalyzerMachineDto req) {
        if(req.getName() != null)
            output.setName(req.getName());
        if(req.getDescription() != null)
            output.setDescription(req.getDescription());
        if(req.getMachineCode() != null)
            output.setMachineCode(req.getMachineCode());
        return output;
    }
}
