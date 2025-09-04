package com.trucdulieu.commoncategory.service.impl;

import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.converter.HTSSConverter;
import com.trucdulieu.commoncategory.model.dto.HTSSDto;
import com.trucdulieu.commoncategory.model.entity.HTSS;
import com.trucdulieu.commoncategory.reporsitory.HTSSRepo;
import com.trucdulieu.commoncategory.service.interfaces.HTSSService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class HTSSImpl implements HTSSService {
    private final HTSSRepo htssRepo;
    private final ModelMapper mapper;

    @Override
    public HTSSDto create(HTSSDto htssDto){
    if (htssDto.getId() != null)
        throw new RuntimeException(Constant.USER_INPUT);
    return mapper.map(
            htssRepo.save(mapper.map(htssDto, HTSS.class)),
            HTSSDto.class);
    }
    @Override
    public List<HTSSDto> findAll(){
        return htssRepo.findAll().stream().map(HTSSConverter::convertToDto)
                .collect(Collectors.toList());
    }
    @Override
    public HTSSDto getById(Long id){
        return htssRepo.findById(id).map(HTSSConverter::convertToDto)
                .orElse(null);
    }
    @Override
    public boolean delete(Long id){
        if(htssRepo.existsById(id)){
            htssRepo.deleteById(id);
        }
        return true;
    }
    @Override
    public HTSSDto update(Long HTSSid, HTSSDto htssDto){
        if (htssDto.getId() != null)
            throw new RuntimeException(Constant.USER_INPUT);
        Optional<HTSS> optionalHTSS = htssRepo.findById(HTSSid);
        HTSS updateHTSS = optionalHTSS.map(
                htss -> HTSSConverter.convertEntity(htssDto, htss)
        ).orElseGet(() -> HTSSConverter.convertEntity(htssDto));
        return mapper.map(htssRepo.save(updateHTSS),HTSSDto.class);
    }
    @Override
    public Page<HTSSDto> filterHTSS(Long id, String name, String code, String description, Pageable pageable){
        return htssRepo.findIdNameDescHTSS(id, name, code, description, pageable)
                .map(HTSSConverter::convertToDto);
    }
}
