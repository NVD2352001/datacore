package com.trucdulieu.commoncategory.reporsitory;

import com.trucdulieu.commoncategory.config.QueryValue;
import com.trucdulieu.commoncategory.model.entity.MedicalRecordTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MedicalRecordTemplateRepo extends JpaRepository<MedicalRecordTemplate, Long> {
    Page<MedicalRecordTemplate> findByName(String name, Pageable pageable);
    @Query(value = QueryValue.CHECKUP_MEDICALRECORDTEMPLATE,nativeQuery = true)
    Page<MedicalRecordTemplate> findWithFilter(Long id, String name,String description,Pageable pageable);
}
