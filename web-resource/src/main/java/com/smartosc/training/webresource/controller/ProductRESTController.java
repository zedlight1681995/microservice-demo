package com.smartosc.training.webresource.controller;

import com.smartosc.training.dto.ProductDTO;
import com.smartosc.training.webresource.entity.Product;
import com.smartosc.training.webresource.mapper.ProductMapper;
import com.smartosc.training.webresource.service.ProductService;
import com.smartosc.training.webresource.service.impl.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/products")
public class ProductRESTController {

    private ProductService productService;

    @Autowired
    public ProductRESTController(final ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<Object> findAllProduct(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "DESC") String sort,
            PagedResourcesAssembler<ProductDTO> assembler) {
//        Pageable pageable = PageRequest.of(pageNo, pageSize,
//                Sort.by(Sort.Direction.fromString(sort), sortBy));
        List<Product> results = productService.findAll();

        List<ProductDTO> responseData = results.stream()
                .map(ProductMapper.INSTANCE::productToProductDTO)
                .collect(Collectors.toList());

        responseData.forEach(o -> {
                    o.add(WebMvcLinkBuilder
                            .linkTo(ProductRESTController.class)
                            .slash(o.getId()).withSelfRel());
                    o.add(WebMvcLinkBuilder
                            .linkTo(WebMvcLinkBuilder.methodOn(ProductRESTController.class)
                                    .updateProduct(o, o.getId())).withRel("update"));
                    o.add(WebMvcLinkBuilder
                            .linkTo(WebMvcLinkBuilder.methodOn(ProductRESTController.class)
                                    .deleteProduct(o.getId())).withRel("delete"));
                }
        );

//        PagedModel<ProductDTO> resultModels = assembler.toModel(responseData);
        CollectionModel<ProductDTO> resultModels = new CollectionModel<>(responseData);
        resultModels.add(WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder.methodOn(ProductRESTController.class)
                        .createProduct(new ProductDTO())).withRel("create"));

        return new ResponseEntity<>(resultModels, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<Object> findProductById(
            @PathVariable("id") Long id) {
        Product result = productService.findById(id);
        ProductDTO responseData = ProductMapper.INSTANCE.productToProductDTO(result);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<Object> createProduct(
            @Valid @RequestBody ProductDTO productDTO) {
        Product product = ProductMapper.INSTANCE.productDTOToProduct(productDTO);
        Product result = productService.save(product);
        ProductDTO responseData = ProductMapper.INSTANCE.productToProductDTO(result);
        return new ResponseEntity<>(responseData, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<Object> updateProduct(
            @RequestBody ProductDTO productDTO, @PathVariable("id") Long id) {
        Product product = ProductMapper.INSTANCE.productDTOToProduct(productDTO);
        Product result = productService.update(product, id);
        ProductDTO responseData = ProductMapper.INSTANCE.productToProductDTO(result);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") Long id) {
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
