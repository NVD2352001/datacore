package com.trucdulieu.commoncategory.service.interfaces;

import com.trucdulieu.commoncategory.base.BaseService;
import com.trucdulieu.commoncategory.model.dto.MedicalRecordTemplateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MedicalRecordTemplateService extends BaseService<MedicalRecordTemplateDto> {
    Page<MedicalRecordTemplateDto> findWithFilter(Long id, String name, String description, Pageable pageable);
}
