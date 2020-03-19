package com.smartosc.training.webservice.service;

import com.smartosc.training.exception.EntityNotFoundException;
import com.smartosc.training.webservice.entity.Product;

import java.util.List;

public interface GeneralService<T> {

    List<T> findByStatus(Integer status);

    Product findById(Long id) throws EntityNotFoundException;

    T save(T object);

    T update(T object, Long id);

    void delete(Long id);
}
