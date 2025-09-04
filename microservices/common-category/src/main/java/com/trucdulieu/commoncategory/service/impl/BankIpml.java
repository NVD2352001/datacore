package com.trucdulieu.commoncategory.service.impl;

import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.converter.BankConverter;
import com.trucdulieu.commoncategory.model.dto.BankDto;
import com.trucdulieu.commoncategory.model.entity.Bank;
import com.trucdulieu.commoncategory.reporsitory.BankRepo;
import com.trucdulieu.commoncategory.service.interfaces.BankService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BankIpml implements BankService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BankRepo repository;

    @Override
    public Page<BankDto> findByPage(Pageable paging) {
        return repository.findAll(paging).map(BankConverter::convertDto);
    }

    @Override
    public Page<BankDto> findByName(String name, Pageable paging) {
        return repository.findByNameContainingIgnoreCase(name, paging).map(BankConverter::convertDto);
    }

    @Override
    public BankDto findById(Long id) {
        return repository.findById(id).map(BankConverter::convertDto).orElse(null);
    }

    @Override
    public List<BankDto> findAll() {
        return repository.findAll().stream().map(BankConverter::convertDto).collect(Collectors.toList());
    }

    @Override
    public BankDto add(BankDto unit) {
        if(unit.getId() != null) throw new RuntimeException(Constant.USER_INPUT);
        return modelMapper.map(
                repository.save(modelMapper.map(unit, Bank.class)),
                BankDto.class
        );
    }

    @Override
    public BankDto update(BankDto unit) {
        if(unit.getId() == null) throw new RuntimeException(Constant.USER_INPUT);
        Optional<Bank> foundDis = repository.findById(unit.getId());
        Bank updateBank = foundDis.map(
                bank -> BankConverter.convertEntity(unit, bank)
        ).orElseGet(() -> BankConverter.convertEntity(unit));
        return modelMapper.map(repository.save(updateBank), BankDto.class);
    }

    @Override
    public Boolean delete(Long id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
        }
        return true;
    }

    @Override
    public Page<BankDto> findWithFilter(Long id, String name, String description, String code, String bin, String shortName, String swiftCode, Pageable paging) {
        return repository.findWithFilter(id, name, description, code, bin, shortName, swiftCode, paging).map(BankConverter::convertDto);
    }

}
