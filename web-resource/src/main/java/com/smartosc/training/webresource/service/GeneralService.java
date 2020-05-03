package com.smartosc.training.webresource.service;

import com.smartosc.training.webresource.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface GeneralService<T> {

    Page<T> findAll(Specification<T> spec, Pageable pageable);

    Product findById(Long id);

    T save(T object);

    T update(T object, Long id);

    void delete(Long id);
}
