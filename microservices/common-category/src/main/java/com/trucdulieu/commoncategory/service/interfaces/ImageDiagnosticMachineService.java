package com.trucdulieu.commoncategory.service.interfaces;

import com.trucdulieu.commoncategory.base.BaseService;
import com.trucdulieu.commoncategory.model.dto.ImageDiagnosticMachineDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ImageDiagnosticMachineService extends BaseService<ImageDiagnosticMachineDto> {
    Page<ImageDiagnosticMachineDto> findWithFilter(Long id, String name, String description, String code,Pageable paging);
}
