package com.smartosc.training.model.request;

import com.smartosc.training.utils.Constraint;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ProductRequestModel {

    private Long id;
    @NotEmpty(message = Constraint.PRODUCT_NAME_EMPTY)
    private String name;
    private String description;
    private String image;
    @NotNull(message = Constraint.PRODUCT_PRICE_EMPTY)
    @DecimalMin(value = "1000", message = Constraint.PRODUCT_PRICE_INVALID)
    private Double price;
    private Integer status;
    private Date createdAt;
    private Date updatedAt;

}
