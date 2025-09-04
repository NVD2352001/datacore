package com.trucdulieu.commoncategory.service.impl;

import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.converter.PackageTypeConverter;
import com.trucdulieu.commoncategory.model.dto.PackageTypeDto;
import com.trucdulieu.commoncategory.model.entity.PackageType;
import com.trucdulieu.commoncategory.reporsitory.PackageTypeRopository;
import com.trucdulieu.commoncategory.service.interfaces.PackageTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PackageTypeServiceImpl implements PackageTypeService {
    @Autowired
    private PackageTypeRopository packageTypeRopository;
    @Override
    public PackageTypeDto getById(Long id) {
        return packageTypeRopository.findById(id).map(PackageTypeConverter::convertDto).orElse(null);
    }

    @Override
    public PackageTypeDto create(PackageTypeDto packageTypeDto) {
        return PackageTypeConverter.convertDto(packageTypeRopository.save(PackageTypeConverter.convertEntity(packageTypeDto)));
    }

    @Override
    public List<PackageTypeDto> getPackageType() {
        List<PackageType> packageTypes = packageTypeRopository.findAll();
        return packageTypes.stream().map(PackageTypeConverter::convertDto).collect(java.util.stream.Collectors.toList());
    }

    @Override
    public Page<PackageTypeDto> filterPackageTypes(Long id, String name, String code, Pageable pageable) {
        return packageTypeRopository.findWithFilter(id, name, code, pageable).map(PackageTypeConverter::convertDto);
    }

    @Override
    public PackageTypeDto update(PackageTypeDto dto) {
        if(dto.getId() == null)
            throw new RuntimeException("User input");
        PackageType item = packageTypeRopository.findById(dto.getId()).orElse(null);
        if(item == null){
            throw new RuntimeException("Not found");
        }
        else {
            item = PackageTypeConverter.convertEntity(dto,item);
            return PackageTypeConverter.convertDto(packageTypeRopository.save(item));
        }
    }

    @Override
    public Boolean delete(Long id) {
        try {
            packageTypeRopository.deleteById(id);
            return true;
        }
        catch (EmptyResultDataAccessException e){
            throw new RuntimeException(Constant.NOT_FOUND);
        }
    }
}
