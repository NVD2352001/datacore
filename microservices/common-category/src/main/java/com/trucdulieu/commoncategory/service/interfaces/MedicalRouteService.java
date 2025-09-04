package com.trucdulieu.commoncategory.service.interfaces;

import com.trucdulieu.commoncategory.model.dto.MedicalRouteDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface MedicalRouteService {


    MedicalRouteDto create(MedicalRouteDto dto);

    List<MedicalRouteDto> findAll();

    MedicalRouteDto getById(Long id);


    MedicalRouteDto update(Long RouteId, MedicalRouteDto mr);

    boolean delete(Long id);

    Page<MedicalRouteDto> filterMR(Long id, String name, String description, Pageable pageable);

}
