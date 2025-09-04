package com.trucdulieu.commoncategory.service.impl;

import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.converter.ChemicalInteractionConverter;
import com.trucdulieu.commoncategory.model.dto.ChemicalInteractionDto;
import com.trucdulieu.commoncategory.model.entity.ChemicalInteraction;
import com.trucdulieu.commoncategory.reporsitory.ChemicalInteractionRepository;
import com.trucdulieu.commoncategory.service.interfaces.ChemicalInteractionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ChemicalInteractionServiceImpl implements ChemicalInteractionService {
    @Autowired
    private ChemicalInteractionRepository chemicalInteractionRepository;

    @Override
    public ChemicalInteractionDto getById(Long id) {
        return chemicalInteractionRepository.findById(id).map(ChemicalInteractionConverter::convertDto).orElse(null);
    }

    @Override
    public ChemicalInteractionDto create(ChemicalInteractionDto chemicalInteractionDto) {
        return ChemicalInteractionConverter.convertDto(chemicalInteractionRepository.save(ChemicalInteractionConverter.convertEntity(chemicalInteractionDto))) ;
    }

    @Override
    public List<ChemicalInteractionDto> getChemicalInteraction() {
        List<ChemicalInteraction> chemicalInteractions = chemicalInteractionRepository.findAll();
        return chemicalInteractions.stream().map(ChemicalInteractionConverter::convertDto).collect(java.util.stream.Collectors.toList()) ;
    }

    @Override
    public Page<ChemicalInteractionDto> filterChemicalInteractions(Long id, String name, String code, String interaction, String creator, Pageable pageable) {
        return chemicalInteractionRepository.findWithFilter(id, name, code, interaction, creator, pageable).map(ChemicalInteractionConverter::convertDto);
    }

    @Override
    public ChemicalInteractionDto update(ChemicalInteractionDto dto) {
        if(dto.getId() == null)
            throw new RuntimeException(Constant.USER_INPUT);
        ChemicalInteraction item = chemicalInteractionRepository.findById(dto.getId()).orElse(null);
        if(item == null){
            throw new RuntimeException(Constant.NOT_FOUND);
        }
        else {
            item = ChemicalInteractionConverter.convertEntity(dto,item);
            return ChemicalInteractionConverter.convertDto(chemicalInteractionRepository.save(item));
        }
    }

    @Override
    public Boolean delete(Long id) {
        try {
            chemicalInteractionRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException(Constant.NOT_FOUND);
        }
    }
}
