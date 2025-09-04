package com.trucdulieu.commoncategory.service.impl;

import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.converter.ManufacturingCountryConverter;
import com.trucdulieu.commoncategory.model.dto.ManufacturingCountryDto;
import com.trucdulieu.commoncategory.model.entity.ManufacturingCountry;
import com.trucdulieu.commoncategory.reporsitory.ManufacturingCountryRepo;
import com.trucdulieu.commoncategory.service.interfaces.ManufacturingCountryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ManufacturingCountryImpl implements ManufacturingCountryService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ManufacturingCountryRepo manufacturingCountryRepo;
    @Override
    public List<ManufacturingCountryDto> findAll() {
        return manufacturingCountryRepo.findAll().stream().map(ManufacturingCountryConverter::connverDto).collect(Collectors.toList());
    }

    @Override
    public Page<ManufacturingCountryDto> findByPage(Pageable paging) {
        return manufacturingCountryRepo.findAll(paging).map(ManufacturingCountryConverter::connverDto);
    }

    @Override
    public Page<ManufacturingCountryDto> findByName(String name, Pageable paging) {
        return manufacturingCountryRepo.findByName(name, paging).map(ManufacturingCountryConverter::connverDto);
    }

    @Override
    public ManufacturingCountryDto findById(Long id) {
        return manufacturingCountryRepo.findById(id).map(ManufacturingCountryConverter::connverDto).orElse(null);
    }

    @Override
    public ManufacturingCountryDto add(ManufacturingCountryDto unit) {
        if(unit.getId()!= null) throw new RuntimeException(Constant.USER_INPUT);
        return modelMapper.map(manufacturingCountryRepo.save(modelMapper.map(unit, ManufacturingCountry.class)),
                ManufacturingCountryDto.class);
    }

    @Override
    public ManufacturingCountryDto update(ManufacturingCountryDto unit) {
        if(unit.getId() == null) throw new RuntimeException(Constant.USER_INPUT);
        Optional<ManufacturingCountry> unitOptional = manufacturingCountryRepo.findById(unit.getId());
        ManufacturingCountry update = unitOptional.map(
                        manufacturingCountry -> ManufacturingCountryConverter.convertEntity(unit, manufacturingCountry))
                .orElseGet(() -> ManufacturingCountryConverter.convertEntity(unit));
        return modelMapper.map(manufacturingCountryRepo.save(update), ManufacturingCountryDto.class);
    }

    @Override
    public Boolean delete(Long id) {
        if (manufacturingCountryRepo.existsById(id)){
            manufacturingCountryRepo.deleteById(id);
        }
        return true;
    }

    @Override
    public Page<ManufacturingCountryDto> findWithFilter(Long id, String name, String description, Pageable pageable) {
        return manufacturingCountryRepo.findWithFilter(id, name, description, pageable).map(ManufacturingCountryConverter::connverDto);

    }
}
