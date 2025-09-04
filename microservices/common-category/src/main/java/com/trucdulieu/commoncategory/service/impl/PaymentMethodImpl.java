package com.trucdulieu.commoncategory.service.impl;

import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.converter.PaymentMethodConverter;
import com.trucdulieu.commoncategory.model.dto.PaymentMethodDto;
import com.trucdulieu.commoncategory.model.entity.PaymentMethod;
import com.trucdulieu.commoncategory.reporsitory.PaymentMethodRepo;
import com.trucdulieu.commoncategory.service.interfaces.PaymentMethodService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PaymentMethodImpl implements PaymentMethodService {
    @Autowired
    private PaymentMethodRepo paymentMethodRepo;
//    @Override
//    public PaymentMethodDto getById(Long id) {
//        Optional<PaymentMethod> paymentMethod = paymentMethodRepo.findById(id);
//        if(paymentMethod.isPresent()) return null;
//        return mapToDo(paymentMethod.get());
//    }

//    private PaymentMethodDto mapToDo(PaymentMethod resp){
//        return new PaymentMethodDto(resp);
//    }
//
//    private PaymentMethod mapToModel(PaymentMethodDto paymentMethodDto, PaymentMethod model){
//        PaymentMethod resp = model == null ? new PaymentMethod(): model;
//        if(paymentMethodDto.getName() != null) resp.setName(paymentMethodDto.getName());
//        if(paymentMethodDto.getDescription() != null) resp.setDescription(paymentMethodDto.getDescription());
//        return resp;
//    }
//    @Override
//    public PaymentMethodDto create(PaymentMethodDto paymentMethodDto) {
//        return mapToDo(paymentMethodRepo.save(mapToModel(paymentMethodDto, null)));
//    }
//
//    @Override
//    public List<PaymentMethodDto> getPaymentMethod() {
//        List<PaymentMethod> paymentMethods = paymentMethodRepo.findAll();
//        return paymentMethods.stream().map(this::mapToDo).collect(Collectors.toList());
//    }
//
//    @Override
//    public Page<PaymentMethodDto> filterPaymentMethod(Long id, String name, Pageable pageable){
//        return paymentMethodRepo.findByDistrictIdAndNameWithPagination(id,name,pageable);
//    }

    @Override
    public List<PaymentMethodDto> findAll() {
        List<PaymentMethod> paymentMethodList = paymentMethodRepo.findAll();
        return paymentMethodList.stream().map(PaymentMethodConverter::convertDto).collect(Collectors.toList());
    }

    @Override
    public Page<PaymentMethodDto> findByPage(Pageable paging) {
        return paymentMethodRepo.findAll(paging).map(PaymentMethodConverter::convertDto);
    }

    @Override
    public Page<PaymentMethodDto> findByName(String name, Pageable paging) {
        Page<PaymentMethod> paymentMethods = paymentMethodRepo.filterPaymentMethod(null, name, paging);
        return paymentMethods.map(PaymentMethodConverter::convertDto);
    }

    @Override
    public PaymentMethodDto findById(Long id) {
        return paymentMethodRepo.findById(id).map(PaymentMethodConverter::convertDto).orElse(null);
    }

    @Override
    public PaymentMethodDto add(PaymentMethodDto unit) {
        return PaymentMethodConverter.convertDto(
                paymentMethodRepo.save(
                        PaymentMethodConverter.convertEntity(
                                unit)));
    }

    @Override
    public PaymentMethodDto update(PaymentMethodDto unit) {
        if(unit.getId() == null) throw new RuntimeException(Constant.USER_INPUT);
        PaymentMethod item = paymentMethodRepo.findById(unit.getId()).orElse(null);
        if(item!= null){
            return PaymentMethodConverter.convertDto(
                    paymentMethodRepo.save(
                            PaymentMethodConverter.convertEntity(
                                    unit, item)));
        } else {
            throw new RuntimeException(Constant.NOT_FOUND);
        }
    }

    @Override
    public Boolean delete(Long id) {
        if(paymentMethodRepo.existsById(id)) {
            paymentMethodRepo.deleteById(id);
        }
        return true;
    }

    @Override
    public Page<PaymentMethodDto> filterPaymentMethod(Long id, String name, Pageable pageable) {
        Page<PaymentMethod> paymentMethods = paymentMethodRepo.filterPaymentMethod(id, name, pageable);
        return paymentMethods.map(PaymentMethodConverter::convertDto);
    }
}
