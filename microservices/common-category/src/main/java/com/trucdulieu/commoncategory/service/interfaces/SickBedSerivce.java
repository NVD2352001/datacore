package com.trucdulieu.commoncategory.service.interfaces;

import com.trucdulieu.commoncategory.base.BaseService;
import com.trucdulieu.commoncategory.model.dto.SickBedDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SickBedSerivce extends BaseService<SickBedDto> {
    Page<SickBedDto> findWithFilter(Long id, String name, Pageable pageable);
}
