package com.trucdulieu.commoncategory.service.impl;

import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.converter.Icd10Converter;
import com.trucdulieu.commoncategory.model.dto.Icd10Dto;
import com.trucdulieu.commoncategory.model.entity.Icd10;
import com.trucdulieu.commoncategory.reporsitory.Icd10Repo;
import com.trucdulieu.commoncategory.service.interfaces.Icd10Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Icd10Impl implements Icd10Service {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private Icd10Repo icd10Repo;
    @Override
    public List<Icd10Dto> findAll() {
        return icd10Repo.findAll().stream().map(Icd10Converter::connverDto).collect(Collectors.toList());
    }

    @Override
    public Page<Icd10Dto> findByPage(Pageable paging) {
        return icd10Repo.findAll(paging).map(Icd10Converter::connverDto);
    }

    @Override
    public Page<Icd10Dto> findByName(String name, Pageable paging) {
        return icd10Repo.findByName(name,paging).map(Icd10Converter::connverDto);
    }

    @Override
    public Icd10Dto findById(Long id) {
        return icd10Repo.findById(id).map(Icd10Converter::connverDto).orElse(null);
    }

    @Override
    public Icd10Dto add(Icd10Dto unit) {
        if (unit.getId() != null) throw new RuntimeException(Constant.USER_INPUT);
        return modelMapper.map(icd10Repo.save(modelMapper.map(unit, Icd10.class)),
                Icd10Dto.class);
    }

    @Override
    public Icd10Dto update(Icd10Dto unit) {
        if (unit.getId() == null) throw new RuntimeException(Constant.USER_INPUT);
        Optional<Icd10> icd10Optional = icd10Repo.findById(unit.getId());
        Icd10 update = icd10Optional.map(
                icd10 -> Icd10Converter.convertEntity(unit, icd10))
                .orElseGet(() -> Icd10Converter.convertEntity(unit));
        return modelMapper.map(icd10Repo.save(update), Icd10Dto.class);
    }

    @Override
    public Boolean delete(Long id) {
        if (icd10Repo.existsById(id)){
            icd10Repo.deleteById(id);
        }
        return true;
    }

    @Override
    public Page<Icd10Dto> findWithFilter(Long id, String name, String code, String chapter, String group, Pageable pageable) {
        return icd10Repo.findWithFilter(id, name, code,chapter,group, pageable).map(Icd10Converter::connverDto);
    }
}
