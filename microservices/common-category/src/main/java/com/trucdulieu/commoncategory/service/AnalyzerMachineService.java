package com.trucdulieu.commoncategory.service;

import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.converter.AnalyzerMachineMapper;
import com.trucdulieu.commoncategory.model.dto.AnalyzerMachineDto;
import com.trucdulieu.commoncategory.model.entity.AnalyzerMachine;
import com.trucdulieu.commoncategory.reporsitory.AnalyzerMachineRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnalyzerMachineService {
    private final ModelMapper modelMapper;
    private final AnalyzerMachineRepository analyzerMachineRepository;

    public AnalyzerMachineDto creat(AnalyzerMachineDto req) {
        if (req.getId() != null)
            throw new RuntimeException(Constant.INVALID_INPUT);
        return modelMapper.map(analyzerMachineRepository.save(modelMapper.map(req, AnalyzerMachine.class)), AnalyzerMachineDto.class);
    }

    public AnalyzerMachineDto update(AnalyzerMachineDto req) {
        if (req.getId() == null)
            throw new RuntimeException(Constant.INVALID_INPUT);
        Optional<AnalyzerMachine> op = analyzerMachineRepository.findById(req.getId());
        AnalyzerMachine analyzerMachine = op.map(output -> AnalyzerMachineMapper.forUpdate(output, req))
                .orElseThrow(() -> new RuntimeException(Constant.NOT_FOUND));
        return modelMapper.map(analyzerMachineRepository.save(analyzerMachine), AnalyzerMachineDto.class);
    }

    public Boolean delete(Long id) {
        if (!analyzerMachineRepository.existsById(id))
            throw new RuntimeException(Constant.NOT_FOUND);
        analyzerMachineRepository.deleteById(id);
        return true;
    }

    public AnalyzerMachineDto getById(Long id) {
        return analyzerMachineRepository.findById(id)
                .map(AnalyzerMachineMapper::toDTO)
                .orElseThrow(() -> new RuntimeException(Constant.NOT_FOUND));
    }

    public List<AnalyzerMachineDto> getAll() {
        return analyzerMachineRepository.findAll()
                .stream()
//                .map(AnalyzerMachineMapper::toDTO)
                .map(machine -> AnalyzerMachineMapper.toDTO(machine))
                .collect(Collectors.toList());
    }

    public Page<AnalyzerMachineDto> findWithFilter(Long id, String name, String machineCode, Pageable pageable) {
        return analyzerMachineRepository.findWithFilter(id, name, machineCode, pageable).map(AnalyzerMachineMapper::toDTO);
    }
}
