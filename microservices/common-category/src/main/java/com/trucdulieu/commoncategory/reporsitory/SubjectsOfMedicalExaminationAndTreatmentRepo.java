package com.trucdulieu.commoncategory.reporsitory;

import com.trucdulieu.commoncategory.config.QueryValue;
import com.trucdulieu.commoncategory.model.entity.SubjectsOfMedicalExaminationAndTreatment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SubjectsOfMedicalExaminationAndTreatmentRepo extends JpaRepository<SubjectsOfMedicalExaminationAndTreatment, Long> {
    Page<SubjectsOfMedicalExaminationAndTreatment> findByName(String name, Pageable paging);
    @Query(value = QueryValue.CHECKUP_SUBJECTSOFMEDICALEXAMINATIONANDTREATMENT, nativeQuery = true)
    Page<SubjectsOfMedicalExaminationAndTreatment> findWithFilter(Long id, String name, String description,Pageable paging);
}
