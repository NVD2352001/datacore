package com.trucdulieu.commoncategory.service.interfaces;

import com.trucdulieu.commoncategory.base.BaseService;
import com.trucdulieu.commoncategory.model.dto.ClinicDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ClinicSerivce extends BaseService<ClinicDto> {
    Page<ClinicDto> findWithFilter(Long id, String name, Pageable paing);
}
