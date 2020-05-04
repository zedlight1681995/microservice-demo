package com.smartosc.training.webresource.assemblers;

import com.smartosc.training.model.request.ProductRequestModel;
import com.smartosc.training.model.response.ProductResponseModel;
import com.smartosc.training.webresource.controller.ProductRESTController;
import com.smartosc.training.webresource.entity.Product;
import com.smartosc.training.webresource.mapper.ProductRequestMapper;
import com.smartosc.training.webresource.mapper.ProductResponseMapper;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ProductDTOAssembler extends RepresentationModelAssemblerSupport<Product, ProductResponseModel> {

    public ProductDTOAssembler() {
        super(ProductRESTController.class, ProductResponseModel.class);
    }

    @Override
    public ProductResponseModel toModel(Product entity) {
        ProductResponseModel productResponseModel = ProductResponseMapper.INSTANCE.productToProductResponseModel(entity);
        ProductRequestModel productRequestModel = ProductRequestMapper.INSTANCE.productToProductRequestModel(entity);
        //Self link
        productResponseModel.add(
                linkTo(ProductRESTController.class)
                .slash(productResponseModel.getId()).withSelfRel(),
                linkTo(methodOn(ProductRESTController.class).
                        updateProduct(productRequestModel, productRequestModel.getId())).withRel("update"),
                linkTo(methodOn(ProductRESTController.class)
                        .deleteProduct(productResponseModel.getId())).withRel("delete")
        );
        return productResponseModel;
    }

    @Override
    public CollectionModel<ProductResponseModel> toCollectionModel(Iterable<? extends Product> entities) {
        return super.toCollectionModel(entities);
    }

}
