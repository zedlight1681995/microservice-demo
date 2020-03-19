package com.smartosc.training.webservice.facade;

import com.smartosc.training.exception.EntityNotFoundException;

import java.util.List;

public interface GeneralFacade<T> {

    List<T> findAll();

    T findById(Long id);

    T save(T object);

    T update(T object, Long id);

    void delete(Long id);
}
