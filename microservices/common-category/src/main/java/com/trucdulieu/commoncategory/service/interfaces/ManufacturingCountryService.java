package com.trucdulieu.commoncategory.service.interfaces;

import com.trucdulieu.commoncategory.base.BaseService;
import com.trucdulieu.commoncategory.model.dto.ManufacturingCountryDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ManufacturingCountryService extends BaseService<ManufacturingCountryDto> {
    Page<ManufacturingCountryDto> findWithFilter(Long id, String name, String description, Pageable pageable);
}
