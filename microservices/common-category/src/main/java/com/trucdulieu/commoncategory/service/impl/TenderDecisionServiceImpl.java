package com.trucdulieu.commoncategory.service.impl;

import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.converter.TenderConverter;
import com.trucdulieu.commoncategory.model.dto.TenderDecisionDto;
import com.trucdulieu.commoncategory.model.entity.TenderDecision;
import com.trucdulieu.commoncategory.reporsitory.TenderDecisionRepository;
import com.trucdulieu.commoncategory.service.interfaces.TenderDecisionService;
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
public class TenderDecisionServiceImpl implements TenderDecisionService {
    @Autowired
    private TenderDecisionRepository tenderDecisionRepository;
    @Override
    public TenderDecisionDto getById(Long id) {
        return tenderDecisionRepository.findById(id).map(TenderConverter::convertDto).orElse(null);
    }

    @Override
    public TenderDecisionDto create(TenderDecisionDto tenderDecisionDto) {
        return TenderConverter.convertDto(tenderDecisionRepository.save(TenderConverter.convertEntity(tenderDecisionDto)));
    }

    @Override
    public List<TenderDecisionDto> getTenderDecision() {
        List<TenderDecision> tenderDecisions = tenderDecisionRepository.findAll();
        return tenderDecisions.stream().map(TenderConverter::convertDto).collect(java.util.stream.Collectors.toList()) ;
    }

    @Override
    public Page<TenderDecisionDto> filterTenderDecisions(Long id, String name, String unit, String tenderNumber, String decision, String decisionDate, Pageable pageable) {
        return tenderDecisionRepository.findWithFilter(id, name, unit, tenderNumber, decision, decisionDate, pageable).map(TenderConverter::convertDto);
    }

    @Override
    public TenderDecisionDto update(TenderDecisionDto dto) {
        if(dto.getId() == null)
            throw new RuntimeException(Constant.USER_INPUT);
        TenderDecision item = tenderDecisionRepository.findById(dto.getId()).orElse(null);
        if(item == null){
            throw new RuntimeException(Constant.NOT_FOUND);
        }
        else {
            item = TenderConverter.convertEntity(dto,item);
            return TenderConverter.convertDto(tenderDecisionRepository.save(item));
        }
    }

    @Override
    public Boolean delete(Long id) {
        try {
            tenderDecisionRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
}
