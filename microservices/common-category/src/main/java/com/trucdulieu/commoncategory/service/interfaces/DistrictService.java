package com.trucdulieu.commoncategory.service.interfaces;

import com.trucdulieu.commoncategory.model.dto.DistrictDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DistrictService {
    DistrictDto getById(Long id);
    DistrictDto create(DistrictDto districtDto);
    List<DistrictDto> getDistrict();

    Page<DistrictDto> filterDistricts(Long id, String name, Pageable pageable);
    public DistrictDto update(DistrictDto dto);

    public Boolean delete(Long id);
}
