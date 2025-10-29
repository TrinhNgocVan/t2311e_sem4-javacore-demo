package org.aptech.t2311e.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.aptech.t2311e.dto.ProductDto;
import org.aptech.t2311e.entity.onetomany.Category;
import org.aptech.t2311e.entity.onetomany.Product;
import org.aptech.t2311e.mapper.mapstruct.ProductMapper;
import org.aptech.t2311e.repository.CategoryRepository;
import org.aptech.t2311e.repository.ProductRepository;
import org.aptech.t2311e.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    ProductMapper mapper;

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;


    @Override
    @Transactional
    @CacheEvict(value = "product-01",key = "#productDto.id")
    public ProductDto insert(ProductDto productDto) {
        // validate
        // name
        if(StringUtils.isEmpty(productDto.getName())){
            throw new  RuntimeException("Product name cannot be empty");
        }

        if(Objects.isNull(productDto.getCategory()) || Objects.isNull(productDto.getCategory().getId())){
            throw new  RuntimeException("Product category cannot be empty");
        }


        Category category = categoryRepository.findById(productDto.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Category id not existed"));

        Product product = mapper.dtoToEntity(productDto);
        product.setCategory(category);
        product = productRepository.saveAndFlush(product);
        productDto = mapper.entityToDto(product);
        redisTemplate.opsForValue().set("product:"+product.getId()
        , productDto, Duration.ofSeconds(300));
        return productDto;
    }

    @Override
    @CacheEvict(value = "product-01",key = "#id")
    public ProductDto update(long id,ProductDto productDto) {
        // update success -> set to cache
        // update success -> clear cache
        Product product =  productRepository.saveAndFlush(mapper.dtoToEntity(productDto));
//        redisTemplate.delete("product:"+product.getId());
        return mapper.entityToDto(product);
    }

    @Override
    @Cacheable(value = "product-01",key = "#id") // neu ko ton tai trong redis -> chay vao ham , neu ton tai trong cache  -> tra ra luon
    public ProductDto get(Long id) throws InterruptedException {
        // check exits in cache  ??  -> if true  return in cache  , if not query in db and set in cache
//        ProductDto product = (ProductDto) redisTemplate.opsForValue().get("product:"+id);
//
//        if(Objects.isNull(product) || Objects.isNull(product.getId())){
            Thread.sleep(10000);
//        ProductDto product = productRepository.findById(id)
//                    .map(mapper::entityToDto)
//                    .orElseThrow(() -> new RuntimeException("Entity not found"));
//            redisTemplate.opsForValue().set("product:"+product.getId()
//                    , product, Duration.ofSeconds(300));
//            return product;
//        }
        ProductDto product = productRepository.findById(id)
                .map(mapper::entityToDto)
                .orElseThrow(() -> new RuntimeException("Entity not found"));
        return product;
    }


}
