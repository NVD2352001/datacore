package com.trucdulieu.commoncategory.controller;

import com.trucdulieu.commoncategory.base.ResponseObject;
import com.trucdulieu.commoncategory.model.dto.PaymentMethodDto;
import com.trucdulieu.commoncategory.service.interfaces.PaymentMethodService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/payment_method")
@RequiredArgsConstructor
public class PaymentMethodController {
    @Autowired
    private PaymentMethodService paymentMethodService;

    @PostMapping
    public ResponseEntity<?> createPaymentMethod(@RequestBody PaymentMethodDto paymentMethodDto){
        return ResponseEntity.ok(new ResponseObject(paymentMethodService.add(paymentMethodDto)));
    }

    @GetMapping
    public ResponseEntity<?> getAllPaymentMethod(){
        return ResponseEntity.ok(new ResponseObject(paymentMethodService.findAll()));
    }

    @GetMapping("/filter")
    public ResponseEntity<?> filterPaymentMethod(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<PaymentMethodDto> paymentMethodDtos = paymentMethodService.filterPaymentMethod(id,name,pageable);
        return ResponseEntity.ok(new ResponseObject(paymentMethodDtos));
    }
    @GetMapping("/{paymentMethodId}")
    public ResponseEntity<?> getPaymentMethodById(@PathVariable Long paymentMethodId){
        return ResponseEntity.ok(new ResponseObject(paymentMethodService.findById(paymentMethodId)));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updatePaymentMethod(@RequestBody PaymentMethodDto paymentMethodDto){
        return ResponseEntity.ok().body(new ResponseObject(paymentMethodService.update(paymentMethodDto)));
    }

    @DeleteMapping("/{paymentMethodId}")
    public ResponseEntity<?> deletePaymentMethod(@PathVariable Long paymentMethodId){
        return ResponseEntity.ok().body(new ResponseObject(paymentMethodService.delete(paymentMethodId)));
    }
}
