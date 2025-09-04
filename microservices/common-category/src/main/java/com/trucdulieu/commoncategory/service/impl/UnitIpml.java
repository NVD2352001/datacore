package com.trucdulieu.commoncategory.service.impl;

import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.converter.UnitConverter;
import com.trucdulieu.commoncategory.model.dto.UnitDto;
import com.trucdulieu.commoncategory.model.entity.Unit;
import com.trucdulieu.commoncategory.reporsitory.UnitRepo;
import com.trucdulieu.commoncategory.service.interfaces.UnitService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UnitIpml implements UnitService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UnitRepo unitRepo;
    @Override
    public List<UnitDto> findAll() {
        return unitRepo.findAll().stream().map(UnitConverter::connverDto).collect(Collectors.toList());
    }

    @Override
    public Page<UnitDto> findByPage(Pageable paging) {
        return unitRepo.findAll(paging).map(UnitConverter::connverDto);
    }

    @Override
    public Page<UnitDto> findByName(String name, Pageable paging) {
        return unitRepo.findByName(name, paging).map(UnitConverter::connverDto);
    }

    @Override
    public UnitDto findById(Long id) {
        return unitRepo.findById(id).map(UnitConverter::connverDto).orElse(null);
    }

    @Override
    public UnitDto add(UnitDto unit) {
        if(unit.getId()!= null) throw new RuntimeException(Constant.USER_INPUT);
        return modelMapper.map(unitRepo.save(modelMapper.map(unit, Unit.class)),
                UnitDto.class);
    }

    @Override
    public UnitDto update(UnitDto unit) {
        if(unit.getId() == null) throw new RuntimeException(Constant.USER_INPUT);
        Optional<Unit> unitOptional = unitRepo.findById(unit.getId());
        Unit updateUnit = unitOptional.map(
                        unit1 -> UnitConverter.convertEntity(unit, unit1))
                .orElseGet(() -> UnitConverter.convertEntity(unit));
        return modelMapper.map(unitRepo.save(updateUnit), UnitDto.class);
    }

    @Override
    public Boolean delete(Long id) {
        if (unitRepo.existsById(id)){
            unitRepo.deleteById(id);
        }
        return true;
    }

    @Override
    public Page<UnitDto> findWithFilter(Long id, String name, String description, Pageable pageable) {
        return unitRepo.findWithFilter(id, name, description, pageable).map(UnitConverter::connverDto);
    }
}
