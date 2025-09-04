package com.trucdulieu.commoncategory.service.impl;

import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.converter.GenderConverter;
import com.trucdulieu.commoncategory.model.dto.GenderDto;
import com.trucdulieu.commoncategory.model.entity.Gender;
import com.trucdulieu.commoncategory.reporsitory.GenderRepo;
import com.trucdulieu.commoncategory.service.interfaces.GenderService;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class GenderServiceImpl implements GenderService {

    @Autowired
    private final GenderRepo genderRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<GenderDto> getByName(String name, Pageable pageable){
        return genderRepo.findByNameContaining(name,pageable).map(GenderConverter::connverDto);
    }

    @Override
    public GenderDto getByGenderId(Long id) {
        return genderRepo.findById(id).map(GenderConverter::connverDto).orElse(null);
    }

    @Override
    public GenderDto createGender(GenderDto genderDto) {
        return modelMapper.map(
                genderRepo.save(modelMapper.map(genderDto, Gender.class)),
                GenderDto.class
        );
    }

    @Override
    public List<GenderDto> getGenders() {
        return genderRepo.findAll().stream().map(GenderConverter::connverDto).collect(Collectors.toList());
    }

    @Override
    public GenderDto updateGender(GenderDto genderDto) {
        if (genderDto.getId() == null) throw new RuntimeException(Constant.USER_INPUT);
        Optional<Gender> genderOptional = genderRepo.findById(genderDto.getId());
        Gender update = genderOptional.map(
                gender -> GenderConverter.convertGenderEntity(genderDto,gender)
        ).orElseGet(() -> GenderConverter.convertGenderEntity(genderDto));
        return modelMapper.map(genderRepo.save(update), GenderDto.class);
    }

    @Override
    public void deleteGender(Long id) {
         genderRepo.deleteById(id);
    }
    @Override
    public Page<GenderDto> filterGender(Long id, String name,String description, Pageable pageable){
        return genderRepo.findWithFilter(id, name,description ,pageable).map(GenderConverter::connverDto);
    }

}
