package com.trucdulieu.commoncategory.service;


import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.converter.ClassificationOfTechnicalServicesMapper;
import com.trucdulieu.commoncategory.model.dto.ClassificationOfTechnicalServicesDto;
import com.trucdulieu.commoncategory.model.entity.ClassificationOfTechnicalServices;
import com.trucdulieu.commoncategory.reporsitory.ClassificationOfTechnicalServicesRepository;
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
public class ClassificationOfTechnicalServicesService {
    private final ModelMapper modelMapper;
    private final ClassificationOfTechnicalServicesRepository technicalServicesRepository;

    public ClassificationOfTechnicalServicesDto creat(ClassificationOfTechnicalServicesDto req) {
        if (req.getId() != null)
            throw new RuntimeException(Constant.INVALID_INPUT);
        return modelMapper.map(
                technicalServicesRepository.save(modelMapper.map(req, ClassificationOfTechnicalServices.class)), ClassificationOfTechnicalServicesDto.class
        );
    }

    public ClassificationOfTechnicalServicesDto update(ClassificationOfTechnicalServicesDto req) {
        if(req.getId() == null)
            throw new RuntimeException(Constant.INVALID_INPUT);
        Optional<ClassificationOfTechnicalServices> op = technicalServicesRepository.findById(req.getId());
        ClassificationOfTechnicalServices technicalServices = op.map(value -> ClassificationOfTechnicalServicesMapper.forUpdate(value, req))
                .orElseThrow(() -> new RuntimeException(Constant.NOT_FOUND));
        return modelMapper.map(technicalServicesRepository.save(technicalServices), ClassificationOfTechnicalServicesDto.class);
    }

    public Boolean delete(Long id) {
        if(!technicalServicesRepository.existsById(id))
            throw new RuntimeException(Constant.NOT_FOUND);
        technicalServicesRepository.deleteById(id);
        return true;
    }

    public ClassificationOfTechnicalServicesDto getById(Long id) {
        return technicalServicesRepository.findById(id)
                .map(ClassificationOfTechnicalServicesMapper::toDTO)
                .orElseThrow(() -> new RuntimeException(Constant.NOT_FOUND));
    }

    public List<ClassificationOfTechnicalServicesDto> getAll() {
        return technicalServicesRepository.findAll()
                .stream()
                .map(ClassificationOfTechnicalServicesMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Page<ClassificationOfTechnicalServicesDto> findWithFilter(Long id, String name, String code, Pageable pageable) {
        return technicalServicesRepository.findWithFilter(id, name, code, pageable).map(ClassificationOfTechnicalServicesMapper::toDTO);
    }
}
