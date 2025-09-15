package org.aptech.t2311e.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "student")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "student_id")
    private String studentId;
    @Column(name = "name")
    private String name;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "gender")
    private Integer gender;  // todo : query  -> convert to enum
    @Column(name = "adress")
    private String address;
    @Column(name = "tel")
    private String tel;
    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassRoom classRoom;

}
