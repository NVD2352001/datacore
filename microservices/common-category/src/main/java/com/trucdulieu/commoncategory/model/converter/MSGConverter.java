package com.trucdulieu.commoncategory.model.converter;

import com.trucdulieu.commoncategory.model.dto.MSGDto;
import com.trucdulieu.commoncategory.model.entity.MSG;

public class MSGConverter {
    public static MSGDto convertDto(MSG msg){
        MSGDto output = new MSGDto();
        if (msg.getId() != null) output.setId(msg.getId());
        if (msg.getName() != null) output.setName(msg.getName());
        if (msg.getDescription() != null) output.setDescription(msg.getDescription());
        if (msg.getCode() != null) output.setCode(msg.getCode());
        return output;
    }
    public static MSG convertEntity (MSGDto msgDto, MSG msg){
        if (msgDto.getId() != null) msg.setId(msgDto.getId());
        if (msgDto.getCode() != null) msg.setCode(msgDto.getCode());
        if (msgDto.getName() != null) msg.setName(msgDto.getName());
        if (msgDto.getDescription() != null) msg.setDescription(msgDto.getDescription());
        return msg;
    }
    public static MSG convertEntity (MSGDto msgDto){
        MSG msg = new MSG();
        if (msgDto.getId() != null) msg.setId(msgDto.getId());
        if (msgDto.getCode() != null) msg.setCode(msgDto.getCode());
        if (msgDto.getName() != null) msg.setName(msgDto.getName());
        if (msgDto.getDescription() != null) msg.setDescription(msgDto.getDescription());
        return msg;
    }
}
