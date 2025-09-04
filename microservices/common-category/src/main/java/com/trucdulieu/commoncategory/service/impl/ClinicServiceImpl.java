package com.trucdulieu.commoncategory.service.impl;

import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.converter.ClinicConverter;
import com.trucdulieu.commoncategory.model.dto.ClinicDto;
import com.trucdulieu.commoncategory.model.entity.Clinic;
import com.trucdulieu.commoncategory.reporsitory.ClinicRepo;
import com.trucdulieu.commoncategory.service.interfaces.ClinicSerivce;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClinicServiceImpl implements ClinicSerivce {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ClinicRepo clinicRepo;

    @Override
    public List<ClinicDto> findAll() {
        return clinicRepo.findAll().stream().map(ClinicConverter::convertDto).collect(Collectors.toList());
    }

    @Override
    public Page<ClinicDto> findByPage(Pageable paging) {
        return clinicRepo.findAll(paging).map(ClinicConverter::convertDto);
    }

    @Override
    public Page<ClinicDto> findByName(String name, Pageable paging) {
        return clinicRepo.findByName(name, paging).map(ClinicConverter::convertDto);
    }

    @Override
    public ClinicDto findById(Long id) {
        return clinicRepo.findById(id).map(ClinicConverter::convertDto).orElse(null);
    }

    @Override
    public ClinicDto add(ClinicDto unit) {
        if(unit.getId()!= null) throw new RuntimeException(Constant.USER_INPUT);
        return modelMapper.map(clinicRepo.save(modelMapper.map(unit, Clinic.class)),
                ClinicDto.class);
    }

    @Override
    public ClinicDto update(ClinicDto unit) {
        if(unit.getId()!= null) throw new RuntimeException(Constant.USER_INPUT);
        Optional<Clinic> clinicOptional = clinicRepo.findById(unit.getId());
        Clinic updateClinic = clinicOptional.map(
                clinic -> ClinicConverter.convertEntity(unit, clinic))
                .orElseGet(() -> ClinicConverter.convertEntity(unit));
        return modelMapper.map(clinicRepo.save(updateClinic), ClinicDto.class);
    }

    @Override
    public Boolean delete(Long id) {
        if (clinicRepo.existsById(id)){
            clinicRepo.deleteById(id);
        }
        return true;
    }

    @Override
    public Page<ClinicDto> findWithFilter(Long id, String name, Pageable pageable) {
        return clinicRepo.findWithFilter(id, name, pageable).map(ClinicConverter::convertDto);
    }
}
