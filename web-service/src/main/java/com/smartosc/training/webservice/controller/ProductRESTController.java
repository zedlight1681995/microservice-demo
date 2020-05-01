package com.smartosc.training.webservice.controller;

import com.smartosc.training.dto.ProductDTO;
import com.smartosc.training.webservice.facade.ProductFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductRESTController {

    private final ProductFacade productFacade;

    @Autowired
    public ProductRESTController(final ProductFacade productFacade) {
        this.productFacade = productFacade;
    }

//    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
//    public ResponseEntity<Object> findAllProduct() {
//        List<ProductDTO> results = productFacade.findAll();
//        results.forEach(o -> {
//                    o.add(WebMvcLinkBuilder
//                            .linkTo(ProductRESTController.class)
//                            .slash(o.getId()).withSelfRel());
//                    o.add(WebMvcLinkBuilder
//                            .linkTo(WebMvcLinkBuilder.methodOn(ProductRESTController.class)
//                                    .updateProduct(o, o.getId())).withRel("update"));
//                    o.add(WebMvcLinkBuilder
//                            .linkTo(WebMvcLinkBuilder.methodOn(ProductRESTController.class)
//                                    .deleteProduct(o.getId())).withRel("delete"));
//                }
//        );
//
//        CollectionModel<ProductDTO> resultModels = new CollectionModel<>(results);
//        try {
//            resultModels.add(WebMvcLinkBuilder
//                    .linkTo(WebMvcLinkBuilder.methodOn(ProductRESTController.class)
//                            .createProduct(new ProductDTO())).withRel("create"));
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        return new ResponseEntity<>(resultModels, HttpStatus.OK);
//    }
//
//    @GetMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
//    public ResponseEntity<Object> findProductById (
//            @PathVariable("id") Long id) {
//        ProductDTO responseData = productFacade.findById(id);
//        return new ResponseEntity<>(responseData, HttpStatus.OK);
//    }
//
//    @PostMapping(produces = MediaTypes.HAL_JSON_VALUE)
//    public ResponseEntity<Object> createProduct(
//            @Valid @RequestBody ProductDTO productDTO) {
//        ProductDTO responseData = productFacade.save(productDTO);
//        return new ResponseEntity<>(responseData, HttpStatus.CREATED);
//    }
//
//    @PutMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
//    public ResponseEntity<Object> updateProduct(
//            @RequestBody ProductDTO productDTO, @PathVariable("id") Long id) {
//        ProductDTO responseData = productFacade.update(productDTO, id);
//        return new ResponseEntity<>(responseData, HttpStatus.OK);
//    }
//
//    @DeleteMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
//    public ResponseEntity<Object> deleteProduct(@PathVariable("id") Long id) {
//        productFacade.delete(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

}
