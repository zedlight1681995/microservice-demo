package com.smartosc.training.webresource.mapper;

import com.smartosc.training.model.request.ProductRequestModel;
import com.smartosc.training.model.response.ProductResponseModel;
import com.smartosc.training.webresource.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductRequestMapper {

    ProductRequestMapper INSTANCE = Mappers.getMapper(ProductRequestMapper.class);

    Product productRequestModelToProduct(ProductRequestModel productModel);
    ProductRequestModel productToProductRequestModel(Product product);

}
