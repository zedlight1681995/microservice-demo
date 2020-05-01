package com.smartosc.training.webresource.service.impl;

import com.smartosc.training.exception.EntityNotFoundException;
import com.smartosc.training.webresource.entity.Product;
import com.smartosc.training.webresource.repository.ProductRepository;
import com.smartosc.training.webresource.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static com.smartosc.training.webresource.utils.Constant.ENTITY_NOTFOUND_ERROR;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private MessageSource messages;

    @Autowired
    public ProductServiceImpl(
            final ProductRepository productRepository,
            @Qualifier("bundleMessageSource") final MessageSource messages) {
        this.productRepository = productRepository;
        this.messages = messages;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findByStatus(1, pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Product findById(Long id) {
        Optional<Product> result = productRepository.findById(id);
        String message = messages.getMessage(
                ENTITY_NOTFOUND_ERROR,
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
                ENTITY_NOTFOUND_ERROR,
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
                ENTITY_NOTFOUND_ERROR,
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
