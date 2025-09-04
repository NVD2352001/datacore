//package com.trucdulieu.commoncategory.service;
//
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//
//import com.trucdulieu.commoncategory.model.dto.BankDto;
//import com.trucdulieu.commoncategory.model.entity.Bank;
//import com.trucdulieu.commoncategory.reporsitory.BankRepo;
//
//import lombok.AllArgsConstructor;
//
//@Service
//@AllArgsConstructor
//public class BankService {
//
//    private final BankRepo bankRepo;
//
//    private BankDto mapToDto(Bank item){
//        BankDto resp= new BankDto(item);
//        return resp;
//    }
//    private Bank mapToModel(BankDto dto, Bank item){
//        Bank resp = item== null? new Bank(): item;
//        if(dto.getName()!= null)  resp.setName(dto.getName());
//        if(dto.getBin()!= null)  resp.setBin(dto.getBin());
//        if(dto.getCode()!= null)  resp.setCode(dto.getCode());
//        if(dto.getShortName()!= null)  resp.setShortName(dto.getShortName());
//        if(dto.getSwiftCode()!= null)  resp.setSwiftCode(dto.getSwiftCode());
//
//        return resp;
//    }
//
//    public List<Bank> getBanks() {
//        return bankRepo.findAll();
//    }
//
//    public BankDto create(BankDto dto){
//        return mapToDto(bankRepo.save(mapToModel(dto, null)));
//    }
//
//    public BankDto update(BankDto dto){
//        if(dto.getId()== null) throw new RuntimeException("Update with null ID");
//        Bank item=bankRepo.findById(dto.getId()).orElse(null);
//
//        if(item!= null){
//            return mapToDto(bankRepo.save(mapToModel(dto, item)));
//        } else {
//            throw new RuntimeException("Update with not existed");
//        }
//    }
//}
