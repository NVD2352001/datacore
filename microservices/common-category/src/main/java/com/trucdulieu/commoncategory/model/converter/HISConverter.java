package com.trucdulieu.commoncategory.model.converter;

import com.trucdulieu.commoncategory.model.dto.HISDto;
import com.trucdulieu.commoncategory.model.entity.HIS;

public class HISConverter {
    public static HISDto converToDto(HIS his){
        HISDto hisDto = new HISDto();
        if (his.getId() != null) hisDto.setId(his.getId());
        if (his.getName() != null) hisDto.setName(his.getName());
        return hisDto;
    }
    public static HIS convertEntity (HISDto hisDto){
        HIS his = new HIS();
        if (hisDto.getId() != null) his.setId(hisDto.getId());
        if (hisDto.getName() != null) his.setName(hisDto.getName());
        return his;
    }
    public static HIS convertEntity (HISDto hisDto, HIS his){
        if (hisDto.getId() != null) his.setId(hisDto.getId());
        if (hisDto.getName() != null) his.setName(hisDto.getName());
        return his;
    }
}
