package org.aptech.t2311e.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aptech.t2311e.entity.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public interface ClassroomProjectionDto {
     Long getId();
     String getName();
     String getCode();
     String getDescription();
     LocalDate getStartTime();
     LocalDate getEndTime();
     Integer getCurrentSemester();
     List<Student> getStudents() ;
     Long getNumberOfStudents();
     Long getNumberEmployedStudents();
     Long getNumberStudentInHanoi();
}
