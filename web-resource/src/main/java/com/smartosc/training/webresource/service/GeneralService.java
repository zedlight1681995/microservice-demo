package com.smartosc.training.webresource.service;

import com.smartosc.training.exception.EntityNotFoundException;
import com.smartosc.training.webresource.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GeneralService<T> {

    Page<T> findAll(Pageable pageable);

    Product findById(Long id) throws EntityNotFoundException;

    T save(T object);

    T update(T object, Long id);

    void delete(Long id);
}
