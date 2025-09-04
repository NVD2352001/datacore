package com.trucdulieu.commoncategory.service.impl;

import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.converter.HISConverter;
import com.trucdulieu.commoncategory.model.dto.HISDto;
import com.trucdulieu.commoncategory.model.entity.HIS;
import com.trucdulieu.commoncategory.reporsitory.HISRepo;
import com.trucdulieu.commoncategory.service.interfaces.HISService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class HISServiceImpl implements HISService {
    private final HISRepo repos;
    private final ModelMapper mapper;

    @Override
    public HISDto create(HISDto hisDto){
        if (hisDto.getId() != null)
            throw new RuntimeException(Constant.USER_INPUT);
        return mapper.map(
                repos.save(mapper.map(hisDto, HIS.class)),
                HISDto.class);
    }
    @Override
    public List<HISDto> findAll(){
        return repos.findAll().stream().map(HISConverter::converToDto)
                .collect(Collectors.toList());
    }
    @Override
    public HISDto getById(Long id){
        return repos.findById(id).map(HISConverter::converToDto)
                .orElse(null);
    }
    @Override
    public boolean delete(Long id){
        if(repos.existsById(id)){
            repos.deleteById(id);
        }
        return true;
    }
    @Override
    public HISDto update(Long id, HISDto hisDto){
        if (hisDto.getId() != null)
            throw new RuntimeException(Constant.USER_INPUT);
        Optional<HIS> optionalHIS = repos.findById(id);
        HIS updateHIS = optionalHIS.map(
                his -> HISConverter.convertEntity(hisDto, his)
        ).orElseGet(() -> HISConverter.convertEntity(hisDto));
        return mapper.map(repos.save(updateHIS),HISDto.class);
    }
    @Override
    public Page<HISDto> filterHISs(Long id, String name, Pageable pageable){
        return repos.findByIdAndName(id, name, pageable)
                .map(HISConverter::converToDto);
    }
}

