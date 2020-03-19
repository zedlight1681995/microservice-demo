package com.smartosc.training.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

@Getter
@Setter
public class OrderDetailDTO extends RepresentationModel<OrderDetailDTO> {

    private Long id;
    private Integer quantity;
    private Double price;
    private ProductDTO product;
    private OrderDTO order;
    private Integer status;
    private Date createdAt;
    private Date updatedAt;

}
