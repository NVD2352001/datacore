package com.trucdulieu.commoncategory.service.interfaces;

import com.trucdulieu.commoncategory.base.BaseService;
import com.trucdulieu.commoncategory.model.dto.UnitDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UnitService extends BaseService<UnitDto> {
    Page<UnitDto> findWithFilter(Long id, String name, String description, Pageable pageable);
}
