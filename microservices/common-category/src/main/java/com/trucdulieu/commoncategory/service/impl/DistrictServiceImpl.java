package com.trucdulieu.commoncategory.service.impl;


import com.trucdulieu.commoncategory.model.converter.DistrictConverter;
import com.trucdulieu.commoncategory.model.dto.DistrictDto;
import com.trucdulieu.commoncategory.model.entity.District;
import com.trucdulieu.commoncategory.reporsitory.DistrictRepository;
import com.trucdulieu.commoncategory.service.interfaces.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.trucdulieu.commoncategory.model.converter.DistrictConverter.convertDto;

@Service
@RequiredArgsConstructor
@Transactional
public class DistrictServiceImpl implements DistrictService {
    private final DistrictRepository districtRepository;

    @Override
    public DistrictDto getById(Long id) {
        return convertDto(districtRepository.findById(id).orElse(null));
//        Optional<District> district = districtRepository.findById(id);
//        if(district.isPresent()) return null;
//        return DistrictConverter.convertDto(district.get());
//        return mapToDto(district.get());
    }

//    private DistrictDto mapToDto(District resp){
//        return new DistrictDto(resp);
//    }
//
//    private District mapToModel(DistrictDto dto, District model){
//        District resp = model == null? new District(): model;
//        if (dto.getName() != null) resp.setName(dto.getName());
//        if(dto.getDescription() != null) resp.setDescription(dto.getDescription());
//        return resp;
//    }

    @Override
    public DistrictDto create(DistrictDto districtDto) {
        return convertDto(districtRepository.save(DistrictConverter.convertEntity(districtDto)));
//        return mapToDto(districtRepository.save(mapToModel(districtDto,null)));
    }
//        District district = District.builder()
//                .id(districtDto.getId())
//                .name(districtDto.getName())
//                .build();
//        districtRepository.save(district);
//        DistrictDto districtDto1 = DistrictDto.builder()
//                .name(district.getName())
//                .build();
//        return districtDto1;
//    }

    @Override
    public List<DistrictDto> getDistrict() {
        List<District> districts = districtRepository.findAll();
        return districts.stream().map(DistrictConverter::convertDto).collect(Collectors.toList());
//        return districts.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public Page<DistrictDto> filterDistricts(Long id, String name, Pageable pageable) {
        Page<District> districts = districtRepository.findByDistrictIdAndNameWithPagination(id, name, pageable);
        return districts.map(DistrictConverter::convertDto);
    }

    @Override
    public DistrictDto update(DistrictDto dto){
        if(dto.getId()== null) throw new RuntimeException("Update with null ID");
        District item=districtRepository.findById(dto.getId()).orElse(null);

        if(item!= null){
            return  convertDto(districtRepository.save(DistrictConverter.convertEntity(dto, item)));
//            return mapToDto(districtRepository.save(mapToModel(dto, item)));
        } else {
            throw new RuntimeException("Update with not existed");
        }
    }

    @Override
    public Boolean delete(Long id) {
        Optional<District> district = districtRepository.findById(id);
        if(district.isPresent()){
            districtRepository.deleteById(id);
        }
        return null;
    }

//    private DistrictDto mapToDto(District district){
//        return DistrictDto.builder()
//                .id(district.getId())
//                .name(district.getName())
//                .build();
//    }
}
