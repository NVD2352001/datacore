package com.trucdulieu.commoncategory.service.interfaces;

import com.trucdulieu.commoncategory.model.dto.PackageTypeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PackageTypeService {
public PackageTypeDto getById(Long id);
    public PackageTypeDto create(PackageTypeDto packageTypeDto);
    public List<PackageTypeDto> getPackageType();

    public Page<PackageTypeDto> filterPackageTypes(Long id, String name, String code, Pageable pageable);
    public PackageTypeDto update(PackageTypeDto dto);

    public Boolean delete(Long id);
}
