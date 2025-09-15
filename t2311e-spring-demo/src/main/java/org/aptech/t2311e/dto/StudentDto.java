package org.aptech.t2311e.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aptech.t2311e.entity.ClassRoom;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private Long id;
    private String studentId;
    private String name;
    private LocalDate dateOfBirth;
    private Integer gender;
    private String address;
    private String tel;
    private ClassRoom classRoom;
}
