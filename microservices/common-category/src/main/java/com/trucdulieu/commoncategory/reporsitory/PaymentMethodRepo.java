package com.trucdulieu.commoncategory.reporsitory;

import com.trucdulieu.commoncategory.config.QueryValue;
import com.trucdulieu.commoncategory.model.entity.PaymentMethod;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepo extends JpaRepository<PaymentMethod,Long> {
    @Query(value = QueryValue.CHECKUP_PAYMENT_METHOD, nativeQuery = true)
    Page<PaymentMethod> filterPaymentMethod(Long id, String name, Pageable pageable);
}
