package com.trucdulieu.commoncategory.service.interfaces;

import com.trucdulieu.commoncategory.base.BaseService;
import com.trucdulieu.commoncategory.model.dto.ManufacturerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ManufacturerService extends BaseService<ManufacturerDto> {
    Page<ManufacturerDto> findWithFilter(Long id, String name, String companyName, String description, Pageable pageable);
}
