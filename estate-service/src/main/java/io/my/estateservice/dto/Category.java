package io.my.estateservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Category {

    private Long id;
    private String categoryName;
    private String description;

}
