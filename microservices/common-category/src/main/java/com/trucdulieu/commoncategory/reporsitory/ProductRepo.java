package com.trucdulieu.commoncategory.reporsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trucdulieu.commoncategory.model.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
