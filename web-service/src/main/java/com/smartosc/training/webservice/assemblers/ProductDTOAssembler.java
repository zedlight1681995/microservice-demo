package com.smartosc.training.webservice.assemblers;

import com.smartosc.training.dto.ProductDTO;
import com.smartosc.training.webservice.controller.ProductRESTController;
import com.smartosc.training.webservice.entity.Product;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProductDTOAssembler extends RepresentationModelAssemblerSupport<Product, ProductDTO> {

    public ProductDTOAssembler() {
        super(ProductRESTController.class, ProductDTO.class);
    }

    @Override
    public ProductDTO toModel(Product entity) {
        ProductDTO productDTO = instantiateModel(entity);

//        productDTO.add(linkTo(
//           methodOn(ProductRESTController.class)
//        ));
        return productDTO;
    }

    @Override
    public CollectionModel<ProductDTO> toCollectionModel(Iterable<? extends Product> entities) {
        return super.toCollectionModel(entities);
    }

}
