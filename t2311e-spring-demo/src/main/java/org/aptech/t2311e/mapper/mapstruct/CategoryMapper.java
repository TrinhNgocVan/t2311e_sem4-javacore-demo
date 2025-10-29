package org.aptech.t2311e.mapper.mapstruct;

import org.aptech.t2311e.dto.CategoryDto;
import org.aptech.t2311e.entity.onetomany.Category;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category dtoToEntity(CategoryDto dto);
    CategoryDto entityToDto(Category category);
}
