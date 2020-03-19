package com.smartosc.training.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
public class RoleDTO extends RepresentationModel<RoleDTO> {

    private Long id;
    private String name;

}
