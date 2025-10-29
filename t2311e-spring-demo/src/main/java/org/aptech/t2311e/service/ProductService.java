package org.aptech.t2311e.service;

import org.aptech.t2311e.dto.ProductDto;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    ProductDto insert(ProductDto productDto);
    ProductDto update(long id,ProductDto productDto);
    ProductDto get(Long id) throws InterruptedException;
}