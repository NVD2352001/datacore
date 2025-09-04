package com.trucdulieu.commoncategory.service.interfaces;

import java.util.List;


import com.trucdulieu.commoncategory.model.dto.WardDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface WardService {
    Page<WardDto> filterWards(Long id, String name, String description, Pageable pageable);

    WardDto getById(Long wardId);
    WardDto create(WardDto wardDto);
    List<WardDto> getWards();

    WardDto update(Long wardId, WardDto wardDto);

    boolean delete(Long id);
}
