package com.smartosc.training.dto;

import com.smartosc.training.utils.Constraint;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class ProductDTO extends RepresentationModel<ProductDTO> {

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
