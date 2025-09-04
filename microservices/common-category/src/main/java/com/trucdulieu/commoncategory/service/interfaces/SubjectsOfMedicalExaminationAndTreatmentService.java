package com.trucdulieu.commoncategory.service.interfaces;

import com.trucdulieu.commoncategory.base.BaseService;
import com.trucdulieu.commoncategory.model.dto.SubjectsOfMedicalExaminationAndTreatmentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SubjectsOfMedicalExaminationAndTreatmentService extends BaseService<SubjectsOfMedicalExaminationAndTreatmentDto> {
    Page<SubjectsOfMedicalExaminationAndTreatmentDto> findWithFilter(Long id, String name, String description, Pageable pageable);

}
