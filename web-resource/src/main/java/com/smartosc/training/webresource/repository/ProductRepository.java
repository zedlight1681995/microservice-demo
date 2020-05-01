package com.smartosc.training.webresource.repository;

import com.smartosc.training.webresource.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Page<Product> findByStatus(Integer status, Pageable pageable);

    Optional<Product> findById(Long id);

    void deleteById(Long id);

}
