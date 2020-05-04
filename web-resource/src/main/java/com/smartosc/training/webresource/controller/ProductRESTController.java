package com.smartosc.training.webresource.controller;

import com.google.common.base.Joiner;
import com.smartosc.training.model.request.ProductRequestModel;
import com.smartosc.training.model.response.ProductResponseModel;
import com.smartosc.training.webresource.assemblers.ProductDTOAssembler;
import com.smartosc.training.webresource.entity.Product;
import com.smartosc.training.webresource.mapper.ProductRequestMapper;
import com.smartosc.training.webresource.mapper.ProductResponseMapper;
import com.smartosc.training.webresource.service.ProductService;
import com.smartosc.training.webresource.service.impl.ProductServiceImpl;
import com.smartosc.training.webresource.utils.GenericSpecificationBuilder;
import com.smartosc.training.webresource.utils.SearchOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Slf4j
@RestController
@RequestMapping("/products")
public class ProductRESTController {

    private ProductService productService;
    private ProductDTOAssembler productDTOAssembler;

    @Autowired
    public ProductRESTController(
            final ProductServiceImpl productService,
            final ProductDTOAssembler productDTOAssembler) {
        this.productService = productService;
        this.productDTOAssembler = productDTOAssembler;
    }

    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<Object> findAllProduct(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "5") Integer size,
            @RequestParam(defaultValue = "id,desc") List<String> sort,
            @RequestParam(value = "search", required = false) String search,
            PagedResourcesAssembler<Product> assembler) {
        //searching
        GenericSpecificationBuilder<Product> builder = new GenericSpecificationBuilder<>();
        String operationSetExper = Joiner.on("|").join(SearchOperation.SIMPLE_OPERATION_SET);
        Pattern pattern = Pattern.compile(
                "(\\p{Punct}?)(\\w+?)("
                        + operationSetExper
                        + ")(\\p{Punct}?)(\\w+?)(\\p{Punct}?),");
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
            builder.with(
                    matcher.group(1),
                    matcher.group(2),
                    matcher.group(3),
                    matcher.group(5),
                    matcher.group(4),
                    matcher.group(6));
        }
        Specification<Product> spec = builder.build();

        //pagination
        Pageable pageable = PageRequest.of(page, size,
                Sort.by(Sort.Direction.fromString(sort.get(1).toUpperCase()), sort.get(0)));
        Page<Product> results = productService.findAll(spec, pageable);

        PagedModel<ProductResponseModel> responseData = assembler.toModel(results, productDTOAssembler);
        responseData.add(linkTo(methodOn(ProductRESTController.class)
                        .createProduct(new ProductRequestModel())).withRel("create"));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<Object> findProductById(
            @PathVariable("id") Long id) {
        Product result = productService.findById(id);
        ProductResponseModel responseData = productDTOAssembler.toModel(result);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<Object> createProduct(
            @Valid @RequestBody ProductRequestModel productRequestModel) {
        Product product = ProductRequestMapper.INSTANCE.productRequestModelToProduct(productRequestModel);
        Product result = productService.save(product);
        ProductResponseModel responseData = ProductResponseMapper.INSTANCE.productToProductResponseModel(result);
        return new ResponseEntity<>(responseData, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<Object> updateProduct(
            @RequestBody ProductRequestModel productRequestModel, @PathVariable("id") Long id) {
        Product product = ProductRequestMapper.INSTANCE.productRequestModelToProduct(productRequestModel);
        Product result = productService.update(product, id);
        ProductResponseModel responseData = ProductResponseMapper.INSTANCE.productToProductResponseModel(result);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") Long id) {
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
