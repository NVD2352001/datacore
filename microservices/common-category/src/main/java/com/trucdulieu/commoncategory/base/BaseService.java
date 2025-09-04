package com.trucdulieu.commoncategory.base;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseService <T>{
    List<T> findAll();
    Page<T> findByPage(Pageable paging);
    Page<T> findByName(String name, Pageable paging);
    T findById(Long id);
    T add(T unit);
    T update(T unit);
    Boolean delete(Long id);
}
