package com.trucdulieu.commoncategory.service.impl;

import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.converter.MedicalRecordTemplateConverter;
import com.trucdulieu.commoncategory.model.dto.MedicalRecordTemplateDto;
import com.trucdulieu.commoncategory.model.entity.MedicalRecordTemplate;
import com.trucdulieu.commoncategory.reporsitory.MedicalRecordTemplateRepo;
import com.trucdulieu.commoncategory.service.interfaces.MedicalRecordTemplateService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicalRecordTemplateIpml implements MedicalRecordTemplateService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MedicalRecordTemplateRepo medicalRecordTemplateRepo;
    @Override
    public List<MedicalRecordTemplateDto> findAll() {
        return medicalRecordTemplateRepo.findAll().stream().map(MedicalRecordTemplateConverter::convertDto).collect(Collectors.toList());
    }

    @Override
    public Page<MedicalRecordTemplateDto> findByPage(Pageable paging) {
        return medicalRecordTemplateRepo.findAll(paging).map(MedicalRecordTemplateConverter::convertDto);
    }

    @Override
    public Page<MedicalRecordTemplateDto> findByName(String name, Pageable paging) {
        return medicalRecordTemplateRepo.findByName(name, paging).map(MedicalRecordTemplateConverter::convertDto);
    }

    @Override
    public MedicalRecordTemplateDto findById(Long id) {
        return medicalRecordTemplateRepo.findById(id).map(MedicalRecordTemplateConverter::convertDto).orElse(null);
    }

    @Override
    public MedicalRecordTemplateDto add(MedicalRecordTemplateDto unit) {
        if(unit.getId()!= null) throw new RuntimeException(Constant.USER_INPUT);
        return modelMapper.map(medicalRecordTemplateRepo.save(modelMapper.map(unit, MedicalRecordTemplate.class)),
                MedicalRecordTemplateDto.class);
    }

    @Override
    public MedicalRecordTemplateDto update(MedicalRecordTemplateDto unit) {
        if(unit.getId()!= null) throw new RuntimeException(Constant.USER_INPUT);
        Optional<MedicalRecordTemplate> medicalRecordTemplateOptional = medicalRecordTemplateRepo.findById(unit.getId());
        MedicalRecordTemplate updateMedicalRT = medicalRecordTemplateOptional.map(
                medicalRecordTemplate -> MedicalRecordTemplateConverter.convertEntity(unit, medicalRecordTemplate))
                .orElseGet(() -> MedicalRecordTemplateConverter.convertEntity(unit));
        return modelMapper.map(medicalRecordTemplateRepo.save(updateMedicalRT), MedicalRecordTemplateDto.class);
    }

    @Override
    public Boolean delete(Long id) {
        if (medicalRecordTemplateRepo.existsById(id)){
            medicalRecordTemplateRepo.deleteById(id);
        }
        return true;
    }

    @Override
    public Page<MedicalRecordTemplateDto> findWithFilter(Long id, String name, String description, Pageable pageable) {
        return medicalRecordTemplateRepo.findWithFilter(id, name, description, pageable).map(MedicalRecordTemplateConverter::convertDto);
    }
}
