package com.trucdulieu.commoncategory.service.impl;

import com.trucdulieu.commoncategory.model.converter.SickBedConverter;
import com.trucdulieu.commoncategory.model.dto.SickBedDto;
import com.trucdulieu.commoncategory.model.entity.SickBed;
import com.trucdulieu.commoncategory.reporsitory.SickBedRepo;
import com.trucdulieu.commoncategory.service.interfaces.SickBedSerivce;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SickBedServiceImpl implements SickBedSerivce {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SickBedRepo sickBedRepo;
    @Override
    public List<SickBedDto> findAll() {
        return sickBedRepo.findAll().stream().map(SickBedConverter::convertDto).collect(Collectors.toList());
    }

    @Override
    public Page<SickBedDto> findByPage(Pageable paging) {
        return sickBedRepo.findAll(paging).map(SickBedConverter::convertDto);
    }
    @Override
    public Page<SickBedDto> findByName(String name, Pageable paging) {
        return sickBedRepo.findByName(name, paging).map(SickBedConverter::convertDto);
    }
    @Override
    public SickBedDto findById(Long id) {
        return sickBedRepo.findById(id).map(SickBedConverter::convertDto).orElse(null);
    }
    @Override
    public SickBedDto add(SickBedDto unit) {
        return modelMapper.map(sickBedRepo.save(modelMapper.map(unit, SickBed.class)),
                SickBedDto.class);
    }

    @Override
    public SickBedDto update(SickBedDto unit) {
        Optional<SickBed> sickBedOptional = sickBedRepo.findById(unit.getId());
        SickBed updateSickBed = sickBedOptional.map(
                        sickBed1 -> SickBedConverter.convertEntity(unit, sickBed1))
                .orElseGet(() -> SickBedConverter.convertEntity(unit));
        return modelMapper.map(sickBedRepo.save(updateSickBed), SickBedDto.class);
    }

    @Override
    public Boolean delete(Long id) {
        if (sickBedRepo.existsById(id)){
            sickBedRepo.deleteById(id);
        }
        return true;
    }

    @Override
    public Page<SickBedDto> findWithFilter(Long id, String name, Pageable pageable) {
        return sickBedRepo.findWithFilter(id, name, pageable).map(SickBedConverter::convertDto);
    }
}
