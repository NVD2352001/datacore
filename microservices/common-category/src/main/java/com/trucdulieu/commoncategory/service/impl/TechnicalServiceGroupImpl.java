package com.trucdulieu.commoncategory.service.impl;

import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.converter.TechnicalServiceGroupConverter;
import com.trucdulieu.commoncategory.model.dto.TechnicalServiceGroupDto;
import com.trucdulieu.commoncategory.model.entity.TechnicalServiceGroup;
import com.trucdulieu.commoncategory.reporsitory.TechnicalServiceGroupRepo;
import com.trucdulieu.commoncategory.service.interfaces.TechnicalServiceGroupService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TechnicalServiceGroupImpl implements TechnicalServiceGroupService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private TechnicalServiceGroupRepo technicalServiceGroupRepo;
    @Override
    public List<TechnicalServiceGroupDto> findAll() {
        return technicalServiceGroupRepo.findAll().stream().map(TechnicalServiceGroupConverter::connverDto).collect(Collectors.toList());
    }

    @Override
    public Page<TechnicalServiceGroupDto> findByPage(Pageable paging) {
        return technicalServiceGroupRepo.findAll(paging).map(TechnicalServiceGroupConverter::connverDto);
    }

    @Override
    public Page<TechnicalServiceGroupDto> findByName(String name, Pageable paging) {
        return technicalServiceGroupRepo.findByName(name, paging).map(TechnicalServiceGroupConverter::connverDto);
    }

    @Override
    public TechnicalServiceGroupDto findById(Long id) {
        return technicalServiceGroupRepo.findById(id).map(TechnicalServiceGroupConverter::connverDto).orElse(null);
    }

    @Override
    public TechnicalServiceGroupDto add(TechnicalServiceGroupDto unit) {
        if(unit.getId()!= null) throw new RuntimeException(Constant.USER_INPUT);
        return modelMapper.map(technicalServiceGroupRepo.save(modelMapper.map(unit, TechnicalServiceGroup.class)),
                TechnicalServiceGroupDto.class);
    }

    @Override
    public TechnicalServiceGroupDto update(TechnicalServiceGroupDto unit) {
        if(unit.getId() == null) throw new RuntimeException(Constant.USER_INPUT);
        Optional<TechnicalServiceGroup> technicalServiceGroupOptional = technicalServiceGroupRepo.findById(unit.getId());
        TechnicalServiceGroup update = technicalServiceGroupOptional.map(
                        technicalServiceGroup -> TechnicalServiceGroupConverter.convertEntity(unit, technicalServiceGroup))
                .orElseGet(() -> TechnicalServiceGroupConverter.convertEntity(unit));
        return modelMapper.map(technicalServiceGroupRepo.save(update), TechnicalServiceGroupDto.class);
    }

    @Override
    public Boolean delete(Long id) {
        if (technicalServiceGroupRepo.existsById(id)){
            technicalServiceGroupRepo.deleteById(id);
        }
        return true;
    }

    @Override
    public Page<TechnicalServiceGroupDto> findWithFilter(Long id, String name, String description, Pageable pageable) {
        return technicalServiceGroupRepo.findWithFilter(id, name, description, pageable).map(TechnicalServiceGroupConverter::connverDto);
    }
}
