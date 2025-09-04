package com.trucdulieu.commoncategory.service.impl;

import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.converter.DiagnosticImagingConverter;
import com.trucdulieu.commoncategory.model.dto.DiagnosticImagingDto;
import com.trucdulieu.commoncategory.model.entity.DiagnosticImaging;
import com.trucdulieu.commoncategory.reporsitory.DiagnosticImagingRepository;
import com.trucdulieu.commoncategory.service.interfaces.DiagnosticImagingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DiagnosticImagingImpl  implements DiagnosticImagingService {
    @Autowired
    private ModelMapper modelMapper ;
    @Autowired
    private DiagnosticImagingRepository diagnosticImagingRepository;
    @Override
    public List<DiagnosticImagingDto> findAll() {
        return diagnosticImagingRepository.findAll().stream().map(DiagnosticImagingConverter::convertDto).collect(Collectors.toList());
    }

    @Override
    public Page<DiagnosticImagingDto> findByPage(Pageable paging) {
        return diagnosticImagingRepository.findAll(paging).map(DiagnosticImagingConverter::convertDto);
    }

    @Override
    public Page<DiagnosticImagingDto> findByName(String name, Pageable paging) {
        return diagnosticImagingRepository.findByNameContainingIgnoreCase(name,paging).map(DiagnosticImagingConverter::convertDto);
    }

    @Override
    public DiagnosticImagingDto findById(Long id) {
        return diagnosticImagingRepository.findById(id).map(DiagnosticImagingConverter::convertDto).orElse(null);
    }

    @Override
    public DiagnosticImagingDto add(DiagnosticImagingDto unit) {
        if(unit.getId()!= null) throw new RuntimeException(Constant.USER_INPUT);
        return modelMapper.map(
                diagnosticImagingRepository.save(modelMapper.map(unit, DiagnosticImaging.class)),
                DiagnosticImagingDto.class
        );
    }

    @Override
    public DiagnosticImagingDto update(DiagnosticImagingDto unit) {
        if(unit.getId()== null) throw new RuntimeException(Constant.USER_INPUT);
        Optional<DiagnosticImaging> foundDiagno = diagnosticImagingRepository.findById(unit.getId());
        DiagnosticImaging updateDiagno = foundDiagno.map(
                diagno -> DiagnosticImagingConverter.convertEntity(unit, diagno)
        ).orElseGet(() -> DiagnosticImagingConverter.convertEntity(unit));
        return modelMapper.map(diagnosticImagingRepository.save(updateDiagno), DiagnosticImagingDto.class);
    }

    @Override
    public Boolean delete(Long id) {
        if (diagnosticImagingRepository.existsById(id)) {
            diagnosticImagingRepository.deleteById(id);
        }
        return true;
    }

    @Override
    public Page<DiagnosticImagingDto> findWithFilter(Long id, String name, String description, Pageable paging) {
        return diagnosticImagingRepository.findWithFilter(id,name,description,paging).map(DiagnosticImagingConverter::convertDto);
    }
}
