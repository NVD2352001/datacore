package com.trucdulieu.commoncategory.service.interfaces;

import com.trucdulieu.commoncategory.model.dto.TenderDecisionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TenderDecisionService {
    public TenderDecisionDto getById(Long id);
    public TenderDecisionDto create(TenderDecisionDto tenderDecisionDto);
    public List<TenderDecisionDto> getTenderDecision();

    public Page<TenderDecisionDto> filterTenderDecisions(Long id, String name, String unit, String tenderNumber, String decision, String decisionDate, Pageable pageable);
    public TenderDecisionDto update(TenderDecisionDto dto);

    public Boolean delete(Long id);
}
