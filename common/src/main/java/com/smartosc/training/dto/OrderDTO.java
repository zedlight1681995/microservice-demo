package com.smartosc.training.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

@Getter
@Setter
public class OrderDTO extends RepresentationModel<OrderDTO> {

    private Long id;
    private Double totalPrice;
    private UserDTO user;
    private Integer status;
    private Date createdAt;
    private Date updatedAt;

}
