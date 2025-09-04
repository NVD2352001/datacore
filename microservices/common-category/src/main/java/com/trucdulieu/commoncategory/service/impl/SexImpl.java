package com.trucdulieu.commoncategory.service.impl;

import com.trucdulieu.commoncategory.model.converter.SexConverter;
import com.trucdulieu.commoncategory.model.dto.SexDto;
import com.trucdulieu.commoncategory.model.entity.Sex;
import com.trucdulieu.commoncategory.reporsitory.SexReposirory;
import com.trucdulieu.commoncategory.service.interfaces.SexSevice;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SexImpl implements SexSevice {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private SexReposirory repository;
    @Override
    public Page<SexDto> findByName(Pageable paging) {
        return repository.findAll(paging).map(SexConverter::convertDto);
    }

    @Override
    public Page<SexDto> findByName(String name, Pageable paging) {
        return repository.findByNameContainingIgnoreCase(name, paging).map(SexConverter::convertDto);
    }

    @Override
    public SexDto findById(Long id) {
        return repository.findById(id).map(jobTitle -> modelMapper.map(jobTitle, SexDto.class))
                .orElse(null);
    }

    @Override
    public SexDto add(SexDto unit) {
        return modelMapper.map(
                repository.save(modelMapper.map(unit, Sex.class)),
                SexDto.class
        );
    }

    @Override
    public SexDto update(SexDto unit) {
        Optional<Sex> foundJobT = repository.findById(unit.getId());
        Sex updateJobT = foundJobT.map(
                jobTitle -> SexConverter.convertEntity(unit, jobTitle)
        ).orElseGet(() -> SexConverter.convertEntity(unit));
        return modelMapper.map(repository.save(updateJobT), SexDto.class);
    }

    @Override
    public Boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        return true;
    }

    @Override
    public List<SexDto> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Page<SexDto> findByPage(Pageable paging) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPage'");
    }

}
