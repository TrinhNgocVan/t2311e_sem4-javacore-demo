package org.aptech.t2311e.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aptech.t2311e.entity.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassRoomDto {
    private Long id;
    private String name;
    private String code;
    private String description;
    private LocalDate startTime;
    private LocalDate endTime;
    private Integer currentSemester;
    private List<Student> students = new ArrayList<>();
    private Integer numberOfStudents;

    private Integer getNumberOfStudents(){
        return this.students.size();
    }
}
