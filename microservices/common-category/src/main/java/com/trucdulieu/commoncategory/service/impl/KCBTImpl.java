package com.trucdulieu.commoncategory.service.impl;

import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.converter.KCBTConverter;
import com.trucdulieu.commoncategory.model.dto.KCBTDto;
import com.trucdulieu.commoncategory.model.entity.KCBT;
import com.trucdulieu.commoncategory.reporsitory.KCBTRepo;
import com.trucdulieu.commoncategory.service.interfaces.KCBTService;
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
public class KCBTImpl implements KCBTService {
    private final KCBTRepo kcbtRepo;
    private final ModelMapper mapper;

    @Override
    public KCBTDto create(KCBTDto kcbtDto){
        if (kcbtDto.getId() != null)
            throw new RuntimeException(Constant.USER_INPUT);
        return mapper.map(
                kcbtRepo.save(mapper.map(kcbtDto, KCBT.class)),
                KCBTDto.class);
    }
    @Override
    public List<KCBTDto> findAll(){
        return kcbtRepo.findAll().stream().map(KCBTConverter::convertDto)
                .collect(Collectors.toList());
    }
    @Override
    public KCBTDto getById(Long id){
        return kcbtRepo.findById(id).map(KCBTConverter::convertDto)
                .orElse(null);
    }
    @Override
    public boolean delete(Long id){
        if(kcbtRepo.existsById(id)){
            kcbtRepo.deleteById(id);
        }
        return true;
    }
    @Override
    public KCBTDto update(Long KCBTid, KCBTDto kcbtDto){
        if (kcbtDto.getId() != null) throw new RuntimeException(Constant.USER_INPUT);
        Optional<KCBT> optionalKCBT = kcbtRepo.findById(KCBTid);
        KCBT updateKCBT = optionalKCBT.map(
                kcbt -> KCBTConverter.convertEntity(kcbtDto,kcbt)
        ).orElseGet(() -> KCBTConverter.convertEntity(kcbtDto));
        return mapper.map(kcbtRepo.save(updateKCBT),KCBTDto.class);
    }
    @Override
    public Page<KCBTDto> filterKCBT(Long id, String name, String description, Pageable pageable){
        return kcbtRepo.findIdNameDescKCBT(id, name, description, pageable)
                .map(KCBTConverter::convertDto);
    }
}
