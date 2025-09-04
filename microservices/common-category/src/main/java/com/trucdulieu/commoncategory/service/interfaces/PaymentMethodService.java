package com.trucdulieu.commoncategory.service.interfaces;

import com.trucdulieu.commoncategory.base.BaseService;
import com.trucdulieu.commoncategory.model.dto.PaymentMethodDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PaymentMethodService extends BaseService<PaymentMethodDto> {
    Page<PaymentMethodDto> filterPaymentMethod(Long id, String name, Pageable pageable);
}
