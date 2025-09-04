package com.trucdulieu.commoncategory.service.impl;

import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.converter.ManufacturerConverter;
import com.trucdulieu.commoncategory.model.dto.ManufacturerDto;
import com.trucdulieu.commoncategory.model.entity.Manufacturer;
import com.trucdulieu.commoncategory.reporsitory.ManufacturerRepo;
import com.trucdulieu.commoncategory.service.interfaces.ManufacturerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ManufacturerImpl implements ManufacturerService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ManufacturerRepo manufacturerRepo;
    @Override
    public List<ManufacturerDto> findAll() {
        return manufacturerRepo.findAll().stream().map(ManufacturerConverter::convertDto).collect(Collectors.toList());
    }

    @Override
    public Page<ManufacturerDto> findByPage(Pageable paging) {
        return manufacturerRepo.findAll(paging).map(ManufacturerConverter::convertDto);
    }

    @Override
    public Page<ManufacturerDto> findByName(String name, Pageable paging) {
        return manufacturerRepo.findByName(name, paging).map(ManufacturerConverter::convertDto);
    }

    @Override
    public ManufacturerDto findById(Long id) {
        return manufacturerRepo.findById(id).map(ManufacturerConverter::convertDto).orElse(null);
    }

    @Override
    public ManufacturerDto add(ManufacturerDto unit) {
        if(unit.getId()!= null) throw new RuntimeException(Constant.USER_INPUT);
        return modelMapper.map(manufacturerRepo.save(modelMapper.map(unit, Manufacturer.class)),
                ManufacturerDto.class);
    }

    @Override
    public ManufacturerDto update(ManufacturerDto unit) {
        if(unit.getId() == null) throw new RuntimeException(Constant.USER_INPUT);
        Optional<Manufacturer> manufacturerOptional = manufacturerRepo.findById(unit.getId());
        Manufacturer updateManufacturer = manufacturerOptional.map(
                        manufacturer -> ManufacturerConverter.convertEntity(unit, manufacturer))
                .orElseGet(() -> ManufacturerConverter.convertEntity(unit));
        return modelMapper.map(manufacturerRepo.save(updateManufacturer), ManufacturerDto.class);
    }

    @Override
    public Boolean delete(Long id) {
        if (manufacturerRepo.existsById(id)){
            manufacturerRepo.deleteById(id);
        }
        return true;
    }

    @Override
    public Page<ManufacturerDto> findWithFilter(Long id, String name, String companyName, String description, Pageable pageable) {
        return manufacturerRepo.findWithFilter(id, name, companyName,description,pageable).map(ManufacturerConverter::convertDto);
    }
}
