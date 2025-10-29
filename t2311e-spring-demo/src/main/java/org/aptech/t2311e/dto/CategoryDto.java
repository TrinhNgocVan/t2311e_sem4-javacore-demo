package org.aptech.t2311e.dto;

import lombok.Data;

import java.util.List;

@Data
public class CategoryDto {
    private Long id;
    private String name;
    private List<ProductDto> products;
}
