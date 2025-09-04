package com.trucdulieu.commoncategory.service.impl;

import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.converter.SubjectsOfMedicalExaminationAndTreatmentConverter;
import com.trucdulieu.commoncategory.model.dto.SubjectsOfMedicalExaminationAndTreatmentDto;
import com.trucdulieu.commoncategory.model.entity.SubjectsOfMedicalExaminationAndTreatment;
import com.trucdulieu.commoncategory.reporsitory.SubjectsOfMedicalExaminationAndTreatmentRepo;
import com.trucdulieu.commoncategory.service.interfaces.SubjectsOfMedicalExaminationAndTreatmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubjectsOfMedicalExaminationAndTreatmentImpl implements SubjectsOfMedicalExaminationAndTreatmentService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private SubjectsOfMedicalExaminationAndTreatmentRepo subjectsOfMedicalExaminationAndTreatmentRepo;
    @Override
    public List<SubjectsOfMedicalExaminationAndTreatmentDto> findAll() {
        return subjectsOfMedicalExaminationAndTreatmentRepo.findAll().stream().map(SubjectsOfMedicalExaminationAndTreatmentConverter::connverDto).collect(Collectors.toList());
    }

    @Override
    public Page<SubjectsOfMedicalExaminationAndTreatmentDto> findByPage(Pageable paging) {
        return subjectsOfMedicalExaminationAndTreatmentRepo.findAll(paging).map(SubjectsOfMedicalExaminationAndTreatmentConverter::connverDto);
    }

    @Override
    public Page<SubjectsOfMedicalExaminationAndTreatmentDto> findByName(String name, Pageable paging) {
        return subjectsOfMedicalExaminationAndTreatmentRepo.findByName(name, paging).map(SubjectsOfMedicalExaminationAndTreatmentConverter::connverDto);
    }

    @Override
    public SubjectsOfMedicalExaminationAndTreatmentDto findById(Long id) {
        return subjectsOfMedicalExaminationAndTreatmentRepo.findById(id).map(SubjectsOfMedicalExaminationAndTreatmentConverter::connverDto).orElse(null);
    }

    @Override
    public SubjectsOfMedicalExaminationAndTreatmentDto add(SubjectsOfMedicalExaminationAndTreatmentDto unit) {
        if(unit.getId()!= null) throw new RuntimeException(Constant.USER_INPUT);
        return modelMapper.map(subjectsOfMedicalExaminationAndTreatmentRepo.save(modelMapper.map(unit, SubjectsOfMedicalExaminationAndTreatment.class)),
                SubjectsOfMedicalExaminationAndTreatmentDto.class);
    }

    @Override
    public SubjectsOfMedicalExaminationAndTreatmentDto update(SubjectsOfMedicalExaminationAndTreatmentDto unit) {
        if(unit.getId() == null) throw new RuntimeException(Constant.USER_INPUT);
        Optional<SubjectsOfMedicalExaminationAndTreatment> subjectsOfMedicalExaminationAndTreatmentOptional = subjectsOfMedicalExaminationAndTreatmentRepo.findById(unit.getId());
        SubjectsOfMedicalExaminationAndTreatment update = subjectsOfMedicalExaminationAndTreatmentOptional.map(
                        subjectsOfMedicalExaminationAndTreatment -> SubjectsOfMedicalExaminationAndTreatmentConverter.convertEntity(unit, subjectsOfMedicalExaminationAndTreatment))
                .orElseGet(() -> SubjectsOfMedicalExaminationAndTreatmentConverter.convertEntity(unit));
        return modelMapper.map(subjectsOfMedicalExaminationAndTreatmentRepo.save(update), SubjectsOfMedicalExaminationAndTreatmentDto.class);
    }

    @Override
    public Boolean delete(Long id) {
        if (subjectsOfMedicalExaminationAndTreatmentRepo.existsById(id)){
            subjectsOfMedicalExaminationAndTreatmentRepo.deleteById(id);
        }
        return true;
    }

    @Override
    public Page<SubjectsOfMedicalExaminationAndTreatmentDto> findWithFilter(Long id, String name, String description, Pageable pageable) {
        return subjectsOfMedicalExaminationAndTreatmentRepo.findWithFilter(id, name, description, pageable).map(SubjectsOfMedicalExaminationAndTreatmentConverter::connverDto);
    }
}
