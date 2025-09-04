package com.trucdulieu.commoncategory.service.impl;

import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.converter.MSGConverter;
import com.trucdulieu.commoncategory.model.dto.MSGDto;
import com.trucdulieu.commoncategory.model.entity.MSG;
import com.trucdulieu.commoncategory.reporsitory.MSGRepo;
import com.trucdulieu.commoncategory.service.interfaces.MSGService;
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

@RequiredArgsConstructor
@Transactional
@Service
public class MSGServiceImpl implements MSGService {
    @Autowired
    private final MSGRepo Mrepos;
    private final ModelMapper mapper;

    @Override
    public MSGDto create(MSGDto msgDto) {
        if(msgDto.getId() != null)
            throw new RuntimeException(Constant.USER_INPUT);
        return mapper.map(
                Mrepos.save(mapper.map(msgDto, MSG.class)),
                MSGDto.class);
//        return mapToDto(Mrepos.save(mapToModel(msgDto, null)));
    }
    @Override
    public MSGDto update(Long msgId, MSGDto msgDto){
        if (msgDto.getId() != null)
            throw new RuntimeException(Constant.USER_INPUT);
        Optional<MSG> optionalMSG = Mrepos.findById(msgId);
        MSG updateMSG = optionalMSG.map(
                msg -> MSGConverter.convertEntity(msgDto,msg)
        ).orElseGet(() -> MSGConverter.convertEntity(msgDto));
        return mapper.map(
                Mrepos.save(updateMSG),
                MSGDto.class);
    }
    @Override
    public List<MSGDto> getMSG(){
        List<MSG> msg = Mrepos.findAll();
        return msg.stream()
                .map(MSGConverter::convertDto)
                .collect(Collectors.toList());
    }
    @Override
    public Page<MSGDto> filterMSG(Long id, String name, String code, String description, Pageable pageable){
        return Mrepos.findIdNameCode(id, name, code, description, pageable)
                .map(MSGConverter::convertDto);
    }
    @Override
    public MSGDto getById(Long id){
        return Mrepos.findById(id)
                .map(MSGConverter::convertDto)
                .orElse(null);
//        Optional<MSG> msg = Mrepos.findById(id);
//        if (!msg.isPresent()){
//            return null;
//        }
//        return mapToDto(msg.get());
    }
//    @Override
//    public MSGDto getByNameCode(String name, String code)
    @Override
    public boolean delete(Long id) {
        if (Mrepos.existsById(id)) {
            Mrepos.deleteById(id);
        }
        return true;
    }
}
