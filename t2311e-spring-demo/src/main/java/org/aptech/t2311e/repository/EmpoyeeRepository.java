package org.aptech.t2311e.repository;


import org.aptech.t2311e.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpoyeeRepository extends JpaRepository<Employee,Long> {
}
