package com.smartosc.training.webresource.mapper;

import com.smartosc.training.model.response.ProductResponseModel;
import com.smartosc.training.webresource.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductResponseMapper {

    ProductResponseMapper INSTANCE = Mappers.getMapper(ProductResponseMapper.class);

    ProductResponseModel productToProductResponseModel(Product product);

}
