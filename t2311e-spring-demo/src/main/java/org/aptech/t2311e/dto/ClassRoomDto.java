package org.aptech.t2311e.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore  // khi truyen qua http -> ko tra ra o api
    private List<Student> students = new ArrayList<>();
    private Long numberOfStudents;
}
