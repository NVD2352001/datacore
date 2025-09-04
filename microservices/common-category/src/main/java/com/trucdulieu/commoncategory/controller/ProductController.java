package com.trucdulieu.commoncategory.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.trucdulieu.commoncategory.model.dto.ProductRqDto;
import com.trucdulieu.commoncategory.model.dto.ProducDto;
import com.trucdulieu.commoncategory.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    //private final ProductService productService;
    @Autowired
    ProductService productService;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductRqDto productRequestDto) {
        return new ResponseEntity(productService.create(productRequestDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProducDto>> getAllProducts() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProducDto> getProductById(@PathVariable Long productId){
        return new ResponseEntity<>(productService.getById(productId), HttpStatus.OK);
    }
}
