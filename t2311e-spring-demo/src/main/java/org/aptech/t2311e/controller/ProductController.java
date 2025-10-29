package org.aptech.t2311e.controller;

import org.aptech.t2311e.dto.ClassRoomDto;
import org.aptech.t2311e.dto.ProductDto;
import org.aptech.t2311e.exception.BussinessException;
import org.aptech.t2311e.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ClassRoomController.class);

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<ProductDto> add(@RequestBody ProductDto productDto) throws BussinessException {
        logger.info("Insert new product  : {} ",productDto);
        return ResponseEntity.ok(productService.insert(productDto));
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDto> get(@PathVariable  long id) throws BussinessException, InterruptedException {
        logger.info("Get product by id  : {} ",id);
        return ResponseEntity.ok(productService.get(id));
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductDto> update(@PathVariable  long id,@RequestBody ProductDto productDto) throws BussinessException, InterruptedException {
        logger.info("Update product by id  : {}, product : {}",id, productDto);
        return ResponseEntity.ok(productService.update(id, productDto));
    }


}
