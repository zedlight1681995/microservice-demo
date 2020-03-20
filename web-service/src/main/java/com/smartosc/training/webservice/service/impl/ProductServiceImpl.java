package com.smartosc.training.webservice.service.impl;

import com.smartosc.training.exception.EntityNotFoundException;
import com.smartosc.training.webservice.entity.Product;
import com.smartosc.training.webservice.repository.ProductRepository;
import com.smartosc.training.webservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final MessageSource messages;

    @Autowired
    public ProductServiceImpl(
            final ProductRepository productRepository,
            @Qualifier("bundleMessageSource") final MessageSource messages) {
        this.productRepository = productRepository;
        this.messages = messages;
    }

    @Override
    public List<Product> findByStatus(Integer status) {
        return productRepository.findByStatus(status);
    }

    @Override
    public Product findById(Long id) throws EntityNotFoundException {
        Optional<Product> result = productRepository.findById(id);
        String message = messages.getMessage(
                "entity.notfound.error",
                new Object[]{Product.class.getSimpleName().toLowerCase(), "ID", id},
                null,
                Locale.getDefault());
        return result.orElseThrow(() -> new EntityNotFoundException(message));
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product, Long id) {
        Optional<Product> result = productRepository.findById(id);
        String message = messages.getMessage(
                "entity.notfound.error",
                new Object[]{Product.class.getSimpleName().toLowerCase(), "ID", id},
                null,
                Locale.getDefault());
        return result.map(o -> {
            o.setName(product.getName());
            o.setDescription(product.getDescription());
            o.setImage(product.getImage());
            o.setPrice(product.getPrice());
            o.setStatus(product.getStatus());
            return productRepository.save(o);
        }).orElseThrow(() -> new EntityNotFoundException(message));
    }

    @Override
    public void delete(Long id) {
        Optional<Product> result = productRepository.findById(id);
        String message = messages.getMessage(
                "entity.notfound.error",
                new Object[]{Product.class.getSimpleName().toLowerCase(), "ID", id},
                null,
                Locale.getDefault());
        if(result.isPresent()) {
            productRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException(message);
        }
    }
}
