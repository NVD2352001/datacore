package com.trucdulieu.commoncategory.reporsitory;

import com.trucdulieu.commoncategory.config.QueryValue;
import com.trucdulieu.commoncategory.model.entity.ChemicalInteraction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ChemicalInteractionRepository extends JpaRepository<ChemicalInteraction, Long> {
    @Query(value = QueryValue.CHECKUP_CHEMICAL_INTERACTION, nativeQuery = true)
    Page<ChemicalInteraction> findWithFilter(Long id, String name,String code, String interaction, String creator, Pageable paging);
}
