package com.trucdulieu.commoncategory.service.impl;

import javax.transaction.Transactional;

import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.converter.WardConverter;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.trucdulieu.commoncategory.model.dto.WardDto;
import com.trucdulieu.commoncategory.model.entity.Ward;
import com.trucdulieu.commoncategory.reporsitory.WardRepo;
import com.trucdulieu.commoncategory.service.interfaces.WardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class WardServiceImpl implements WardService {
    private final WardRepo wardrepo;
    private final ModelMapper mapper;


    @Override
    public WardDto create(WardDto wardDto) {
        if (wardDto.getId() != null)
            throw new RuntimeException(Constant.USER_INPUT);
        return mapper.map(
                wardrepo.save(mapper.map(wardDto, Ward.class)),
                WardDto.class);

//        return mapToDto(wardrepo.save(mapToModel(wardDto,null)));
//        Ward ward = new Ward();
//        ward.setName(wardDto.getName());
//        ward.setDescription(ward.getDescription());
//        Ward saveWard = wardrepo.save(ward);
//        return mapToDto(saveWard);
    }
    @Override
    public WardDto update(Long wardId, WardDto wardDto) {
        if (wardDto.getId() != null )
            throw new RuntimeException(Constant.USER_INPUT);
        Optional<Ward> optionalWard = wardrepo.findById(wardId);
        Ward updateWard = optionalWard.map(
                ward -> WardConverter.convertToEntity(wardDto, ward)
        ).orElseGet(() -> WardConverter.convertToEntity(wardDto));
        return mapper.map(wardrepo.save(updateWard), WardDto.class);

//        if (optionalWard.isPresent()) {
//            Ward ward = optionalWard.get();
//            ward.setName(wardDto.getName());
//            ward.setDescription(wardDto.getDescription());
//            Ward updatedWard = wardrepo.save(ward);
//            return Optional.of(mapToDto(updatedWard));
//        } else {
//            return null;
//        }
    }
    
    @Override
    public List<WardDto> getWards() {
        return wardrepo.findAll().stream()
                .map(WardConverter::convertToDto)
                .collect(Collectors.toList());
//        List<Ward> wards = wardrepo.findAll();
//        return wards.stream()
//                .map(this::mapToDto)
//                .collect(Collectors.toList());
    }

    @Override
    public Page<WardDto> filterWards(Long id, String name, String description, Pageable pageable) {
        return wardrepo.findByIdAndName(id, name, description, pageable)
                .map(WardConverter::convertToDto);
    }

    @Override
    public WardDto getById(Long id) {
        return wardrepo.findById(id)
                .map(WardConverter::convertToDto)
                .orElse(null);
//        Optional<Ward> ward = wardrepo.findById(id);
//        if (!ward.isPresent()){
//            return null;
//        }
//        return mapToDto(ward.get());
    }
//    private WardDto mapToDto(Ward ward){
//        return new WardDto(ward);
//        return WardDto.builder()
//                .id(ward.getId())
//                .name(ward.getName())
//                .description(ward.getDescription())
//                .build();
//    }
//    private Ward mapToModel(WardDto wardDto, Ward model){
//        Ward ward = model == null? new Ward():model;
//        if (wardDto.getName() != null) ward.setName(wardDto.getName());
//        if (wardDto.getDescription() != null) ward.setDescription(wardDto.getDescription());
//        return ward;
//    }
    @Override
    public boolean delete(Long id){
        if (wardrepo.existsById(id)){
            wardrepo.deleteById(id);
        }
        return true;
    }
}
