package com.trucdulieu.commoncategory.service.impl;

import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.converter.ImageDiagnosticMachineConverter;
import com.trucdulieu.commoncategory.model.dto.ImageDiagnosticMachineDto;
import com.trucdulieu.commoncategory.model.entity.ImageDiagnosticMachine;
import com.trucdulieu.commoncategory.reporsitory.ImageDiagnosticMachineRepository;
import com.trucdulieu.commoncategory.service.interfaces.ImageDiagnosticMachineService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ImageDiagnosticMachineImpl implements ImageDiagnosticMachineService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ImageDiagnosticMachineRepository imageDiagnosticMachineRepository;
    @Override
    public List<ImageDiagnosticMachineDto> findAll() {
        return imageDiagnosticMachineRepository.findAll().stream().map(ImageDiagnosticMachineConverter::convertDto).collect(Collectors.toList());
    }

    @Override
    public Page<ImageDiagnosticMachineDto> findByPage(Pageable paging) {
        return imageDiagnosticMachineRepository.findAll(paging).map(ImageDiagnosticMachineConverter::convertDto);
    }

    @Override
    public Page<ImageDiagnosticMachineDto> findByName(String name, Pageable paging) {
        return imageDiagnosticMachineRepository.findByNameContainingIgnoreCase(name, paging).map(ImageDiagnosticMachineConverter::convertDto);
    }

    @Override
    public ImageDiagnosticMachineDto findById(Long id) {
        return imageDiagnosticMachineRepository.findById(id).map(ImageDiagnosticMachineConverter::convertDto).orElse(null);
    }

    @Override
    public ImageDiagnosticMachineDto add(ImageDiagnosticMachineDto unit) {
        if(unit.getId() != null) throw new RuntimeException(Constant.USER_INPUT);
        return modelMapper.map(
                imageDiagnosticMachineRepository.save(modelMapper.map(unit, ImageDiagnosticMachine.class)),
               ImageDiagnosticMachineDto.class
        );
    }

    @Override
    public ImageDiagnosticMachineDto update(ImageDiagnosticMachineDto unit) {
        if(unit.getId() == null) throw new RuntimeException(Constant.USER_INPUT);
        Optional<ImageDiagnosticMachine> foundDis = imageDiagnosticMachineRepository.findById(unit.getId());
        ImageDiagnosticMachine updateidm = foundDis.map(
                idm -> ImageDiagnosticMachineConverter.convertEntity(unit, idm)
        ).orElseGet(() -> ImageDiagnosticMachineConverter.convertEntity(unit));
        return modelMapper.map(imageDiagnosticMachineRepository.save(updateidm), ImageDiagnosticMachineDto.class);
    }

    @Override
    public Boolean delete(Long id) {
        if(imageDiagnosticMachineRepository.existsById(id)) {
            imageDiagnosticMachineRepository.deleteById(id);
        }
        return true;
    }

    @Override
    public Page<ImageDiagnosticMachineDto> findWithFilter(Long id, String name, String description, String code, Pageable paging) {
        return imageDiagnosticMachineRepository.findWithFilter(id, name, description, code, paging).map(ImageDiagnosticMachineConverter::convertDto);
    }
}
