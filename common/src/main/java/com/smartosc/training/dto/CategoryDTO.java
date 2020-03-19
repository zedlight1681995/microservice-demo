package com.smartosc.training.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

@Getter
@Setter
public class CategoryDTO extends RepresentationModel<CategoryDTO> {

    private Long id;
    private String name;
    private String description;
    private Integer status;
    private Date createdAt;
    private Date updatedAt;

}
