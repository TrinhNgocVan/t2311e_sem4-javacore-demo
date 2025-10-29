package org.aptech.t2311e.entity;


import jakarta.persistence.*;
import lombok.*;

// mapping : object in program  <---> db
@Entity //
@Table(name = "employee")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    ///  mapping : properties of object  => column in table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "employee_name",unique = true,nullable = false)
    private String name;
    @Column(name = "age")
    private int age;

}
