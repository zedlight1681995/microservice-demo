package com.smartosc.training.webservice.repository;

import com.smartosc.training.webservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByStatus(Integer status);

    Optional<Product> findById(Long id);

    void deleteById(Long id);

}
