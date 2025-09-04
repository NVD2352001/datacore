package com.trucdulieu.commoncategory.service.interfaces;

import com.trucdulieu.commoncategory.base.BaseService;
import com.trucdulieu.commoncategory.model.dto.DiagnosticImagingDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DiagnosticImagingService extends BaseService<DiagnosticImagingDto> {
    Page<DiagnosticImagingDto> findWithFilter(Long id, String name, String description, Pageable paging);
}
