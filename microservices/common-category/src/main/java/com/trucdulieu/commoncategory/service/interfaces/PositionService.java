package com.trucdulieu.commoncategory.service.interfaces;

import com.trucdulieu.commoncategory.base.BaseService;
import com.trucdulieu.commoncategory.model.dto.PositionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PositionService extends BaseService<PositionDto> {
    Page<PositionDto> findWithFilter(Long id, String name, String description, Pageable paging);
}
