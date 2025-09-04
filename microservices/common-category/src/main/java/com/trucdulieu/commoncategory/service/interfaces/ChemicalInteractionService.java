package com.trucdulieu.commoncategory.service.interfaces;

import com.trucdulieu.commoncategory.model.dto.ChemicalInteractionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ChemicalInteractionService {
    public ChemicalInteractionDto getById(Long id);
    public ChemicalInteractionDto create(ChemicalInteractionDto chemicalInteractionDto);
    public List<ChemicalInteractionDto> getChemicalInteraction();

    public Page<ChemicalInteractionDto> filterChemicalInteractions(Long id, String name, String code, String interaction, String creator, Pageable pageable);
    public ChemicalInteractionDto update(ChemicalInteractionDto dto);

    public Boolean delete(Long id);
}
