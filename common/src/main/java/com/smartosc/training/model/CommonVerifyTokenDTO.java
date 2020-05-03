package com.smartosc.training.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

@Getter
@Setter
public class CommonVerifyTokenDTO extends RepresentationModel<CommonVerifyTokenDTO> {

    private Long id;
    private String token;
    private UserDTO user;
    private Boolean activated;
    private Date expiryDate;

}
