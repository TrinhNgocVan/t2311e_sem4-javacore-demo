package org.aptech.t2311e.repository;

import org.aptech.t2311e.entity.Employee;
import org.aptech.t2311e.entity.onetomany.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
