package org.aptech.t2311e.mapper.mapstruct;

import org.aptech.t2311e.dto.CategoryDto;
import org.aptech.t2311e.dto.ProductDto;
import org.aptech.t2311e.entity.onetomany.Category;
import org.aptech.t2311e.entity.onetomany.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ProductMapper {
    Product dtoToEntity(ProductDto dto);
    ProductDto entityToDto(Product product);

    @Mapping(source = "products", target = "products", ignore = true)
    CategoryDto entityToDto(Category category);
}
