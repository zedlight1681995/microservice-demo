package com.smartosc.training.webservice.facade.impl;

import com.smartosc.training.dto.ProductDTO;
import com.smartosc.training.webservice.entity.Product;
import com.smartosc.training.webservice.facade.ProductFacade;
import com.smartosc.training.webservice.facade.mapper.ProductMapper;
import com.smartosc.training.webservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductFacadeImpl implements ProductFacade {

    private final ProductService productService;

    @Autowired
    public ProductFacadeImpl(final ProductService productService) {
        this.productService = productService;
    }

    @Override
    public List<ProductDTO> findAll() {
        List<Product> products = productService.findByStatus(1);
        return products.stream()
                .map(ProductMapper.INSTANCE::productToProductDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO findById(Long id) {
        Product product = productService.findById(id);
        return product != null ? ProductMapper.INSTANCE.productToProductDTO(product) : null;
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product product = ProductMapper.INSTANCE.productDTOToProduct(productDTO);
        Product result = productService.save(product);
        return result != null ? ProductMapper.INSTANCE.productToProductDTO(result) : null ;
    }

    @Override
    public ProductDTO update(ProductDTO productDTO, Long id) {
        Product product = ProductMapper.INSTANCE.productDTOToProduct(productDTO);
        Product result = productService.update(product, id);
        return result != null ? ProductMapper.INSTANCE.productToProductDTO(result) : null;
    }

    @Override
    public void delete(Long id) {
        productService.delete(id);
    }

}
