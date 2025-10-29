package org.aptech.t2311e.service;

import org.aptech.t2311e.entity.Employee;
import org.aptech.t2311e.repository.EmpoyeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class EmployeeService {

//    @Autowired
    private EmpoyeeRepository empoyeeRepository; //  = null

    public Employee save(Employee employee){
        empoyeeRepository.save(employee);
        return employee;
    }

}
