package com.trucdulieu.commoncategory.service;

import java.util.List;

import com.trucdulieu.commoncategory.model.dto.ProductRqDto;
import com.trucdulieu.commoncategory.model.dto.ProducDto;

public interface ProductService {
    ProducDto getById(Long id);
    ProducDto create(ProductRqDto productRequestDto);
    List<ProducDto> getProducts();
}
